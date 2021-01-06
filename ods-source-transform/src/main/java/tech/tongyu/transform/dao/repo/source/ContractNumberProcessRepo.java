package tech.tongyu.transform.dao.repo.source;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import tech.tongyu.transform.dao.source.ContractNumberProcessDbo;

import java.util.List;
import java.util.Optional;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 双方约定编号数据处理
 */
public interface ContractNumberProcessRepo extends JpaRepository<ContractNumberProcessDbo, String> {

    /**
     * 获取双方约定编号数据处理
     * @return 双方约定编号数据处理
     */
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query("from ContractNumberProcessDbo c where c.archive = false and c.execId is NULL")
    List<ContractNumberProcessDbo> getContractNumberProcessReport();

    /**
     * 获取双方约定编号数据处理
     * @param bizId 业务编号
     * @return 双方约定编号数据处理
     */
    @Query("from ContractNumberProcessDbo d where d.bizId = ?1")
    Optional<ContractNumberProcessDbo> getContractReportByBizID(String bizId);

    /**
     * 获取双方约定编号数据处理
     * @param execId 操作流水号
     * @return 双方约定编号数据处理
     */
    @Query("from ContractNumberProcessDbo d where d.execId = ?1")
    Optional<ContractNumberProcessDbo> getContractReportByExecID(String execId);

    /**
     * 根据业务编码删除数据
     * @param bizId 业务编码
     */
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query(value = "delete from ContractNumberProcessDbo d where d.bizId = ?1")
    void deleteByBizId(String bizId);

    /**
     * 根据业务编码删除数据
     */
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query(value = "delete from ContractNumberProcessDbo d where d.execId is NULL")
    void deleteReportList();

    /**
     * 更新ExecID
     * @param id 唯一ID
     * @param execId 操作流水ID
     */
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query(value = "update ContractNumberProcessDbo d set d.execId = ?2 where d.id = ?1")
    void modifyAgreementExecID(String id, String execId);

}
