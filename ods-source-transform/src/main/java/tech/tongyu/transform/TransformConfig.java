package tech.tongyu.transform;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import tech.tongyu.transform.manager.TransformManagerConfig;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description transform服务扫描类
 **/
@Configuration
@ComponentScan(basePackageClasses = TransformConfig.class)
@Import({TransformManagerConfig.class})
public class TransformConfig {
}
