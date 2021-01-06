package tech.tongyu.core.utils.jpa;

import org.hibernate.dialect.PostgreSQL95Dialect;

public class PgDialect extends PostgreSQL95Dialect {
    public PgDialect() {
        super();
        registerColumnType(9001, "jsonb");
    }
}
