package tech.tongyu.transform.manager;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import tech.tongyu.transform.check.CheckConfig;
import tech.tongyu.transform.dao.TransformRepoConfig;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description transform服务manager层扫描类
 **/
@Configuration
@ComponentScan(basePackageClasses = TransformManagerConfig.class)
@Import({TransformRepoConfig.class, CheckConfig.class})
public class TransformManagerConfig {
}
