package tech.tongyu.model;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import tech.tongyu.model.service.ModelServiceConfig;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description Model服务基础扫描类
 **/
@Configuration
@ComponentScan(basePackageClasses = ModelConfig.class)
@Import({ModelServiceConfig.class})
public class ModelConfig {
}
