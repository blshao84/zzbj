package tech.tongyu.transform.dao.repo.history;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tech.tongyu.transform.dao.history.ContractHistoryDbo;

import java.util.Optional;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description A1015
 */
public interface ContractHistoryRepo extends JpaRepository<ContractHistoryDbo, String> {

    /**
     * 获取双方约定编号数据处理
     * @param bizId 业务编号
     * @return 双方约定编号数据处理
     */
    @Query("from ContractHistoryDbo d where d.bizId = ?1")
    Optional<ContractHistoryDbo> getReportByBizID(String bizId);

}
