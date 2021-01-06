package tech.tongyu.center.initialize;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tech.tongyu.model.dao.config.BaseElementDbo;
import tech.tongyu.transform.manager.CustomizeQueryManager;

import java.util.ArrayList;
import java.util.List;

@Component
public class BaseConfigInitialize {

    private CustomizeQueryManager customizeQueryManager;

    @Autowired
    public BaseConfigInitialize(CustomizeQueryManager customizeQueryManager) {
        this.customizeQueryManager = customizeQueryManager;
    }

    @Order(1)
    @Bean
    CommandLineRunner dbInitialize(){
        return new CommandLineRunner() {
            @Override
            @Transactional(rollbackFor = Exception.class)
            public void run(String... args) {

            }
        };
    }
}
