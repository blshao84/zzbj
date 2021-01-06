package tech.tongyu.transform.service;

import tech.tongyu.core.enums.OperationEnum;
import tech.tongyu.model.dao.config.BaseElementDbo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 校验与填充
 **/
public interface CheckAndSupplementService {

    /**
     * 校验数据 && 填充数据
     * @param data 初始数据
     * @param elements 字段
     * @return 已完成校验和填充数据
     */
    Map<String, Object> checkAndSupplementValue(Map<String, Object> data, List<BaseElementDbo>elements);

    /**
     * 获取规范化数据
     * 注意:
     *   1.规范化数据需要进行校验与填充
     *   2.返回的数据已完成结构重组,可以直接生成xml文件
     * @param dataList 初始数据
     * @param elements 字段
     * @return 规范化数据
     */
    List<Map<String, Object>> getStandardValue(List<Map<String, Object>> dataList, List<BaseElementDbo> elements);

    /**
     * 校验数据
     * @param reportData 需要校验数据
     * @param operation 操作
     * @return 完成校验数据
     */
    LinkedHashMap<String, Object> validData(LinkedHashMap<String, Object> reportData, OperationEnum operation);
}
