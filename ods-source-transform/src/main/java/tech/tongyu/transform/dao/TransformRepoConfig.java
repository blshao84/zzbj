package tech.tongyu.transform.dao;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import tech.tongyu.transform.dao.history.MasterHistoryDbo;
import tech.tongyu.transform.dao.repo.history.MasterAgreementHistoryRepo;
import tech.tongyu.transform.dao.repo.source.MasterAgrmtRepo;
import tech.tongyu.transform.dao.source.MasterAgrmtDbo;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 转换服务dao层扫描
 */
@Configuration
@ComponentScan(basePackageClasses = TransformRepoConfig.class)
@EnableJpaRepositories(basePackageClasses = {MasterAgrmtRepo.class, MasterAgreementHistoryRepo.class})
@EntityScan(basePackageClasses = {MasterAgrmtDbo.class, MasterHistoryDbo.class})
public class TransformRepoConfig {
}
