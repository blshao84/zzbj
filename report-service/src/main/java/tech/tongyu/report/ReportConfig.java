package tech.tongyu.report;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import tech.tongyu.report.service.ReportServiceConfig;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description Report服务基础扫描类
 **/
@Configuration
@ComponentScan(basePackageClasses = ReportConfig.class)
@Import({ReportServiceConfig.class})
public class ReportConfig {
}
