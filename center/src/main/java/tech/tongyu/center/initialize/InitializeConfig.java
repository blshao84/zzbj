package tech.tongyu.center.initialize;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import tech.tongyu.transform.manager.TransformManagerConfig;

@Configuration
@ComponentScan(basePackageClasses = InitializeConfig.class)
@Import(TransformManagerConfig.class)
public class InitializeConfig {
}
