package tech.tongyu.transform.dao.repo.history;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tech.tongyu.transform.dao.history.OptionConfirmationHistoryDbo;

import java.util.Optional;

public interface OptionConfirmationHistoryRepo extends JpaRepository<OptionConfirmationHistoryDbo, String> {

    /**
     * 获取数据
     * @param bizId 业务编号
     * @return 数据
     */
    @Query("from OptionConfirmationHistoryDbo d where d.bizId = ?1")
    Optional<OptionConfirmationHistoryDbo> getReportByBizID(String bizId);
}
