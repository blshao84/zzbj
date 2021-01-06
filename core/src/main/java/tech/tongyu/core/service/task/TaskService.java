package tech.tongyu.core.service.task;

import tech.tongyu.core.enums.TransStepEnum;

public interface TaskService {

    /**
     * 执行任务
     * @param code 报告code
     * @param transStep 执行步骤
     * @return 执行是否结束
     */
    Boolean executeTaskScript(String code, TransStepEnum transStep);

}
