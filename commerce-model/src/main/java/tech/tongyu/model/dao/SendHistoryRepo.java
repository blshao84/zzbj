package tech.tongyu.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.tongyu.model.dao.history.SendHistoryDbo;

import java.time.LocalDate;
import java.util.List;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 发送记录
 **/
public interface SendHistoryRepo extends JpaRepository<SendHistoryDbo, String> {

    /**
     * 获取发送历史
     * @param operationDate 操作日期
     * @return 发送历史
     */
    List<SendHistoryDbo> findAllByOperationDate(LocalDate operationDate);
}
