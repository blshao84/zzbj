package tech.tongyu.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.tongyu.model.dao.history.ReceiveHistoryDbo;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 接收
 **/
public interface ReceiveHistoryRepo extends JpaRepository<ReceiveHistoryDbo, String> {

}
