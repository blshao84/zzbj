package tech.tongyu.transform.dao.repo.history;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tech.tongyu.transform.dao.history.ContractHistoryDbo;
import tech.tongyu.transform.dao.history.EventReportHistoryDbo;

import java.util.Optional;

public interface EventReportHistoryRepo extends JpaRepository<EventReportHistoryDbo, String> {

    /**
     * 获取数据
     * @param bizId 业务编号
     * @return 数据
     */
    @Query("from EventReportHistoryDbo d where d.bizId = ?1")
    Optional<EventReportHistoryDbo> getReportByBizID(String bizId);

}
