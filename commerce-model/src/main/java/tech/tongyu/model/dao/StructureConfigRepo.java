package tech.tongyu.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.tongyu.core.enums.InterfaceInfoEnum;
import tech.tongyu.model.dao.config.StructureConfigDbo;

import java.util.Optional;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 结构化信息
 **/
public interface StructureConfigRepo extends JpaRepository<StructureConfigDbo, Integer> {

    /**
     * 根据协议名称查询协议信息
     * @param agreementName 协议名称
     * @return 协议信息
     */
    Optional<StructureConfigDbo> findAllByAgreementName(String agreementName);

    /**
     * 根据协议接口类型查询协议类型
     * @param code 接口信息
     * @return 协议信息
     */
    Optional<StructureConfigDbo> findAllByCode(String code);
}
