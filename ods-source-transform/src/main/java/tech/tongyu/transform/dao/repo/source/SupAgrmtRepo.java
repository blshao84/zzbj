package tech.tongyu.transform.dao.repo.source;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import tech.tongyu.transform.dao.source.SupAgrmtDbo;

import java.util.List;
import java.util.Optional;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 补充协议
 */
public interface SupAgrmtRepo extends JpaRepository<SupAgrmtDbo, String> {

    /**
     * 获取主协议关联产品列表
     *
     * @return 主协议关联产品列表
     */
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query("from SupAgrmtDbo d where d.archive = false and d.execId is NULL")
    List<SupAgrmtDbo> getReport();

    /**
     * 获取主协议关联产品列表
     *
     * @param bizId 业务编号
     * @return 主协议关联产品列表
     */
    @Query("from SupAgrmtDbo d where d.bizId = ?1")
    Optional<SupAgrmtDbo> getReportByBizID(String bizId);

    /**
     * 获取主协议关联产品列表
     *
     * @param execId 操作流水号
     * @return 主协议关联产品列表
     */
    @Query("from SupAgrmtDbo d where d.execId = ?1")
    Optional<SupAgrmtDbo> getReportByExecID(String execId);

    /**
     * 根据业务编码删除数据
     *
     * @param bizId 业务编码
     */
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query(value = "delete from SupAgrmtDbo d where d.bizId = ?1")
    void deleteByBizId(String bizId);

    /**
     * 根据业务编码删除数据
     */
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query(value = "delete from SupAgrmtDbo d where d.execId is NULL")
    void deleteReportList();

    /**
     * 更新ExecID
     *
     * @param id     唯一ID
     * @param execId 操作流水ID
     */
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query(value = "update SupAgrmtDbo d set d.execId = ?2 where d.id = ?1")
    void modifyAgreementExecID(String id, String execId);
}
