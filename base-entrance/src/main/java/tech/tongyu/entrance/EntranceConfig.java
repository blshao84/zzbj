package tech.tongyu.entrance;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import tech.tongyu.entrance.exception.ExceptionConfig;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description Entrance服务基础扫描类
 **/
@Configuration
@ComponentScan(basePackageClasses = EntranceConfig.class)
@Import({ExceptionConfig.class})
public class EntranceConfig {
}
