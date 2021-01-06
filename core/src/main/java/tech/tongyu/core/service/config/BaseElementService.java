package tech.tongyu.core.service.config;

import tech.tongyu.core.dto.common.BaseElementDTO;

import java.util.List;
import java.util.Map;

public interface BaseElementService {

    /**
     * 根据code获取BaseElement数据
     * @param code
     * @return
     */
    List<BaseElementDTO> getBaseElementList(String code);

    /**
     * 根据ID更新BASE_ELEMENT表
     * @param data BASE_ELEMENT表数据
     * @param id 业务编码
     * @return 是否完成更新
     */
    Boolean updateBaseElement(String id, Map<String, Object> data);

    /**
     * 根据ID删除BASE_ELEMENT表
     * @param id ID
     * @return 是否完成删除
     */
    Boolean deleteBaseElement(String id);

    /**
     * 新增BASE_ELEMENT表
     *
     * @param id
     */
    Boolean addBaseElement(String id, Map<String, Object> data);


}
