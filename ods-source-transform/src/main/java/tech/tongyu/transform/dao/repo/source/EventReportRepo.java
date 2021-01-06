package tech.tongyu.transform.dao.repo.source;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import tech.tongyu.transform.dao.source.EventReportDbo;

import java.util.List;
import java.util.Optional;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 重大事件报告
 **/
public interface EventReportRepo extends JpaRepository<EventReportDbo, String> {


    /**
     * 获取未归档数据
     * @return 未归档数据
     */
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query("from EventReportDbo d where d.archive = false and d.execId is NULL")
    List<EventReportDbo> getEventReport();

    /**
     * 获取业务数据
     * @param bizId 业务编号
     * @return 业务数据
     */
    @Query("from EventReportDbo d where d.bizId = ?1")
    Optional<EventReportDbo> getReportByBizID(String bizId);

    /**
     * 获取业务数据
     * @param execId 操作流水号
     * @return 业务数据
     */
    @Query("from EventReportDbo d where d.execId = ?1")
    Optional<EventReportDbo> getReportByExecID(String execId);

    /**
     * 根据业务编码删除数据
     * @param bizId 业务编码
     */
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query(value = "delete from EventReportDbo d where d.bizId = ?1")
    void deleteByBizId(String bizId);

    /**
     * 根据业务编码删除数据
     */
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query(value = "delete from EventReportDbo d where d.execId is NULL")
    void deleteReportList();

    /**
     * 更新ExecID
     * @param id 唯一ID
     * @param execId 操作流水ID
     */
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query(value = "update EventReportDbo d set d.execId = ?2 where d.id = ?1")
    void modifyReportExecID(String id, String execId);
}
