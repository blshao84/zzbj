package tech.tongyu.model.dao;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import tech.tongyu.model.dao.config.BaseElementDbo;
import tech.tongyu.model.dao.history.SendHistoryDbo;

@Configuration
@ComponentScan(basePackageClasses = BaseRepoConfig.class)
@EnableJpaRepositories
@EntityScan(basePackageClasses = {BaseElementDbo.class, SendHistoryDbo.class})
public class BaseRepoConfig {
}
