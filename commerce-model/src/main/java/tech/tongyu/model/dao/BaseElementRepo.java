package tech.tongyu.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tech.tongyu.model.dao.config.BaseElementDbo;

import java.util.List;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 基础元素
 **/
public interface BaseElementRepo extends JpaRepository<BaseElementDbo, String> {

    /**
     * 根据协议接口标识查询字段列表
     * @param code 协议接口标识
     * @return 字段列表
     */
    List<BaseElementDbo> findAllByCode(String code);

    /**
     * 根据协议接口标识模糊查询字段列表
     * @param code 协议接口标识
     * @return 字段列表
     */
    @Query(value = "select * from commerce_model.BASE_ELEMENT where code like ?1", nativeQuery = true)
    List<BaseElementDbo> findAllByCodeLike(String code);

}
