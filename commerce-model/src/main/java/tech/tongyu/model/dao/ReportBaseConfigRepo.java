package tech.tongyu.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.tongyu.model.dao.config.ReportBaseConfigDbo;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 报告基础配置
 **/
public interface ReportBaseConfigRepo extends JpaRepository<ReportBaseConfigDbo, String> {
}
