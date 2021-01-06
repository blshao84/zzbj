package tech.tongyu.transform.dao.repo.history;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tech.tongyu.transform.dao.history.SupHistoryDbo;
import tech.tongyu.transform.dao.history.SwapConfirmationHistoryDbo;

import java.util.Optional;

public interface SwapConfirmationHistoryRepo extends JpaRepository<SwapConfirmationHistoryDbo, String> {

    /**
     * 获取数据
     * @param bizId 业务编号
     * @return 数据
     */
    @Query("from SwapConfirmationHistoryDbo d where d.bizId = ?1")
    Optional<SwapConfirmationHistoryDbo> getReportByBizID(String bizId);
}
