package tech.tongyu.transform.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import tech.tongyu.model.dao.config.BaseElementDbo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 自定义查询操作类
 **/
@Component
public class CustomizeQueryManager {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    /**
     * 获取ods数据
     * 注意: 这个方法只能获取相同表的数据,若信息由多张表组成请不要使用这个方法
     * @param elements 字段列表
     * @return ods数据
     */
    @Transactional(rollbackFor = Exception.class)
    public List<Map<String, Object>> queryCustomizeList(List<BaseElementDbo> elements) {
        Map<String, List<BaseElementDbo>> dataMap = elements.stream()
                .collect(Collectors.groupingBy(element -> element.getOdsSchema()+ "." + element.getOdsTableName()));
        List<Map<String, Object>> data = new ArrayList<>();
        dataMap.entrySet()
                .forEach(entry -> {
                    List<BaseElementDbo> value = entry.getValue();
                    StringBuffer stringBuffer = generateQuery(value, entry.getKey());
                    Query query = entityManager.createNativeQuery(stringBuffer.toString());
                    List<Object[]> resultList = query.getResultList();
                    resultList.forEach(result -> {
                        Map<String, Object> map = new HashMap<>();
                        for (int i = 0;i < entry.getValue().size();i++) {
                            map.put(value.get(i).getElementName(), result[i]);
                        }
                        data.add(map);
                    });
                });
        return data;
    }

    /**
     * 获取ods数据
     * 注意: 此方法会根据数据库名与表名组合获取多个表的数据
     * @param elements 字段列表
     * @return ods数据
     */
    @Transactional(rollbackFor = Exception.class)
    public List<Map<String, Object>> queryCustomizeMultiList(List<BaseElementDbo> elements) {
        List<Map<String, Object>> data = new ArrayList<>();
        StringBuffer sql = generateQuery(elements);
        Query query = entityManager.createNativeQuery(sql.toString());
        List<Object[]> resultList = query.getResultList();
        resultList.forEach(result -> {
            Map<String, Object> map = new HashMap<>();
            for (int i = 0;i < elements.size();i++) {
                map.put(elements.get(i).getElementName(), result[i]);
            }
            data.add(map);
        });
        return data;
    }

    /**
     * 执行外部传入的sql语句
     * @param sql 外部传入sql
     */
    public void executeTruncateSql(String sql) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(platformTransactionManager);
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                entityManager.createNativeQuery(sql).executeUpdate();
            }
        });
    }

    public StringBuffer generateQuery(List<BaseElementDbo> fieldList, String tablePath) {
        StringBuffer sql = new StringBuffer("select ");
        fieldList.forEach(field -> {
            sql.append(field.getOdsName() + ",");
        });
        sql.deleteCharAt(sql.length() - 1);
        sql.append(" from " + tablePath);
        return sql;
    }

    public StringBuffer generateQuery(List<BaseElementDbo> fieldList) {
        List<String> tables = fieldList.stream()
                .map(BaseElementDbo::getOdsTableName)
                .distinct()
                .collect(Collectors.toList());
        Map<String, List<BaseElementDbo>> associates = fieldList.stream()
                .filter(field -> field.getUseAssociate())
                .collect(Collectors.groupingBy(BaseElementDbo::getOdsTableName));
        StringBuffer sql = new StringBuffer("select ");
        fieldList.forEach(field -> {
            sql.append(field.getOdsTableName() + "." + field.getOdsName() + ",");
        });
        sql.deleteCharAt(sql.length() - 1);
        sql.append(" from " + tables.get(0));
        List<BaseElementDbo> first = associates.get(tables.get(0));
        BaseElementDbo firstField = first.stream().findAny().get();
        for (int i = 1;i < tables.size();i++) {
            List<BaseElementDbo> baseElementDbos = associates.get(tables.get(i));
            BaseElementDbo any = baseElementDbos.stream().findAny().get();
            sql.append(" left join "+ tables.get(i) + " on " +
                    any.getOdsTableName() + "." + any.getOdsName() + " = " +
                    firstField.getOdsTableName() + "." + firstField.getOdsName());
        }
        return sql;
    }

}
