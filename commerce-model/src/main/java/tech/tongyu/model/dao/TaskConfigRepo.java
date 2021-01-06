package tech.tongyu.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.tongyu.core.enums.TransStepEnum;
import tech.tongyu.model.dao.config.TaskConfigDbo;

import java.util.List;

public interface TaskConfigRepo extends JpaRepository<TaskConfigDbo, Integer> {

    /**
     * 查询任务配置列表
     * @param code 报告code
     * @param transStep 执行步骤
     * @return 任务配置列表
     */
    List<TaskConfigDbo> findAllByCodeAndTransStep(String code, TransStepEnum transStep);

}
