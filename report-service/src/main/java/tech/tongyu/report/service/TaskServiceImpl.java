package tech.tongyu.report.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.tongyu.core.enums.TransStepEnum;
import tech.tongyu.core.service.task.TaskService;
import tech.tongyu.core.utils.ShellUtils;
import tech.tongyu.model.dao.TaskConfigRepo;
import tech.tongyu.model.dao.config.TaskConfigDbo;
import tech.tongyu.transform.manager.CustomizeQueryManager;

import java.util.Comparator;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskConfigRepo taskConfigRepo;
    private CustomizeQueryManager customizeQueryManager;

    @Autowired
    public TaskServiceImpl(TaskConfigRepo taskConfigRepo,
                           CustomizeQueryManager customizeQueryManager) {
        this.taskConfigRepo = taskConfigRepo;
        this.customizeQueryManager = customizeQueryManager;
    }

    @Override
    public Boolean executeTaskScript(String code, TransStepEnum transStep) {
        List<TaskConfigDbo> tasks = taskConfigRepo.findAllByCodeAndTransStep(code, transStep);
        tasks.stream()
                .sorted(Comparator.comparingInt(TaskConfigDbo::getSort))
                .filter(TaskConfigDbo::getExecute)
                .forEach(task -> {
                    switch (task.getScriptType()) {
                        case CMD:
                            ShellUtils.ExecCommand(task.getParam());
                            break;
                        case SQL:
                            customizeQueryManager.executeTruncateSql(task.getParam());
                            break;
                        default:
                            break;
                    }
                });
        return true;
    }
}
