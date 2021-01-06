package tech.tongyu.transform.dao.repo.history;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tech.tongyu.transform.dao.history.PerformanceHistoryDbo;

import java.util.Optional;

public interface PerformanceHistoryRepo extends JpaRepository<PerformanceHistoryDbo, String> {

    /**
     * 获取数据
     * @param bizId 业务编号
     * @return 数据
     */
    @Query("from PerformanceHistoryDbo d where d.bizId = ?1")
    Optional<PerformanceHistoryDbo> getReportByBizID(String bizId);
}
