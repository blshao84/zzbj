package tech.tongyu.transform.dao.repo.history;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import tech.tongyu.transform.dao.history.ContractHistoryDbo;
import tech.tongyu.transform.dao.history.MasterHistoryDbo;
import tech.tongyu.transform.dao.source.MasterAgrmtDbo;

import java.util.Optional;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 主协议
 */
public interface MasterAgreementHistoryRepo extends JpaRepository<MasterHistoryDbo, String> {

    /**
     * 获取数据
     * @param bizId 业务编号
     * @return 数据
     */
    @Query("from MasterHistoryDbo d where d.bizId = ?1")
    Optional<MasterHistoryDbo> getReportByBizID(String bizId);

}
