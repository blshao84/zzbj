package tech.tongyu.external;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description External服务基础扫描类
 **/
@Configuration
@ComponentScan(basePackageClasses = ExternalConfig.class)
public class ExternalConfig {
}
