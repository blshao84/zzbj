package tech.tongyu.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.oas.annotations.EnableOpenApi;
import tech.tongyu.entrance.EntranceConfig;
import tech.tongyu.external.ExternalConfig;
import tech.tongyu.model.ModelConfig;
import tech.tongyu.report.ReportConfig;
import tech.tongyu.transform.TransformConfig;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 行情Api服务模块
 * @date 23:19 2020/8/5 0005
 **/
@EnableOpenApi
@SpringBootApplication
@Import({ModelConfig.class, EntranceConfig.class, ExternalConfig.class, TransformConfig.class, ReportConfig.class})
public class CenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(CenterApplication.class, args);
    }
}
