package tech.tongyu.core.utils.jpa;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.hibernate.HibernateException;
import org.hibernate.boot.registry.classloading.internal.ClassLoaderServiceImpl;
import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.SerializationException;
import org.hibernate.usertype.ParameterizedType;
import org.hibernate.usertype.UserType;
import org.postgresql.util.PGobject;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.io.IOException;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

import static com.fasterxml.jackson.core.JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN;

@Component
public class JsonNodeType implements UserType, ParameterizedType {

    private static final ObjectMapper objectMapper;

    private static final ClassLoaderService classLoaderService = new ClassLoaderServiceImpl();

    public static final String CLASS = "CLASS";

    private Class<?> jsonClassType;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule()).registerModule(new ParameterNamesModule());
        objectMapper.getSerializerProvider().setNullValueSerializer(new MapNullValueSerializer());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
        objectMapper.enable(WRITE_BIGDECIMAL_AS_PLAIN);
    }

    static class MapNullValueSerializer extends StdSerializer<Object> {
        public MapNullValueSerializer() {
            this(null);
        }

        public MapNullValueSerializer(Class<Object> t) {
            super(t);
        }

        @Override
        public void serialize(Object value, JsonGenerator gen, SerializerProvider provider) throws IOException {
            gen.writeNull();
        }
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session)
            throws SQLException {
        if (value == null) {
            st.setNull(index, Types.OTHER);
        } else {
            try {
                String json = objectMapper.writeValueAsString(value);
                st.setObject(index, json, Types.OTHER);
            } catch (Exception e) {
                e.printStackTrace();
                st.setNull(index, Types.OTHER);
            }
        }
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner)
            throws SQLException {
        Object o = rs.getObject(names[0]);
        if (o == null) {
            return objectMapper.createObjectNode();
        } else {
            if (o instanceof PGobject && ((PGobject) o).getValue() != null) {
                try {
                    return objectMapper.readValue(((PGobject) o).getValue(), jsonClassType);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (o instanceof String) {
                try {
                    return objectMapper.readValue((String) o, jsonClassType);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return objectMapper.createObjectNode();
    }

    @Override
    public Object deepCopy(Object orig) {
        if (orig != null) {
            try {
                return objectMapper.readValue(objectMapper.writeValueAsString(orig),
                        returnedClass());
            } catch (IOException e) {
                throw new HibernateException("Failed to deep copy object", e);
            }
        }
        return null;
    }

    @Override
    public Serializable disassemble(Object value) {
        Object copy = deepCopy(value);

        if (copy instanceof Serializable) {
            return (Serializable) copy;
        }

        throw new SerializationException(String.format("Cannot serialize '%s', %s is not Serializable.",
                value, value.getClass()), null);
    }

    @Override
    public Object assemble(Serializable cached, Object owner) {
        return deepCopy(cached);
    }

    @Override
    public Object replace(Object orig, Object target, Object owner) {
        return deepCopy(orig);
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public int hashCode(Object x) {
        if (x == null)
            return 0;
        return x.hashCode();
    }

    @Override
    public boolean equals(Object x, Object y) {
        return ObjectUtils.nullSafeEquals(x, y);
    }

    @Override
    public Class<?> returnedClass() {
        return jsonClassType;
    }

    @Override
    public void setParameterValues(Properties properties) {
        final String clazz = (String) properties.get(CLASS);
        if (clazz != null) {
            jsonClassType = classLoaderService.classForName(clazz);
        } else {
            jsonClassType = JsonNode.class;
        }
    }

    @Override
    public int[] sqlTypes() {
        return new int[]{9001};
    }
}
