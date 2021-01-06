package tech.tongyu.model.dao.config;

import tech.tongyu.core.enums.TaskScriptEnum;
import tech.tongyu.core.enums.TransStepEnum;
import tech.tongyu.model.dao.common.BaseEntity;

import javax.persistence.*;

import static tech.tongyu.core.constant.ServiceConstant.*;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @author dongjianghai
 * - mailto: dongjianghai@tongyu.tech
 * @description 任务配置
 **/
@Entity
@Table(schema = COMMERCE_MODEL, name= TASK_CONFIG)
public class TaskConfigDbo extends BaseEntity {
    /**
     * 任务名
     */
    @Column
    private String taskName;

    /**
     * 结构code
     */
    @Column
    private String code;

    /**
     * 是否执行
     */
    @Column
    private Boolean execute;

    /**
     * 任务步骤大类
     */
    @Column
    @Enumerated(value = EnumType.STRING)
    private TransStepEnum transStep;

    /**
     * 脚本类型
     */
    @Column
    @Enumerated(value = EnumType.STRING)
    private TaskScriptEnum scriptType;

    /**
     * 任务执行脚本
     */
    @Column
    private String param;

    /**
     * 排序
     */
    @Column
    private Integer sort;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getExecute() {
        return execute;
    }

    public void setExecute(Boolean execute) {
        this.execute = execute;
    }

    public TransStepEnum getTransStep() {
        return transStep;
    }

    public void setTransStep(TransStepEnum transStep) {
        this.transStep = transStep;
    }

    public TaskScriptEnum getScriptType() {
        return scriptType;
    }

    public void setScriptType(TaskScriptEnum scriptType) {
        this.scriptType = scriptType;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}

