package tech.tongyu.transform.dao.repo.history;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tech.tongyu.transform.dao.history.MasterProductHistoryDbo;

import java.util.Optional;

public interface MasterProductHistoryRepo extends JpaRepository<MasterProductHistoryDbo, String> {

    /**
     * 获取数据
     * @param bizId 业务编号
     * @return 数据
     */
    @Query("from MasterProductHistoryDbo d where d.bizId = ?1")
    Optional<MasterProductHistoryDbo> getReportByBizID(String bizId);

}
