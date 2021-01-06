package tech.tongyu.entrance.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.tongyu.core.dto.common.JsonRequest;
import tech.tongyu.core.dto.common.JsonRequestCollection;
import tech.tongyu.core.dto.optionconfirmation.OptionConfirmationDTO;
import tech.tongyu.core.enums.OperationEnum;
import tech.tongyu.core.service.base.OptionConfirmationService;
import tech.tongyu.core.utils.FileUtils;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 期权交易确认书
 */
@RestController
@RequestMapping("option-confirmation")
public class OptionConfirmationApi {

    private final OptionConfirmationService optionConfirmationService;

    @Autowired
    public OptionConfirmationApi(OptionConfirmationService optionConfirmationService) {
        this.optionConfirmationService = optionConfirmationService;
    }

    /**
     * 查询期权交易确认书的report层数据
     * @return 是否完成抽取
     */
    @GetMapping(value = "trans")
    public List<OptionConfirmationDTO> getDataSource() {
        return optionConfirmationService.listOptionConfirmation();
    }

    /**
     * 执行ods至report层的数据检查和转换
     * @return 是否完成
     */
    @PostMapping(value = "trans", produces = APPLICATION_JSON_VALUE)
    public Boolean executeTransTask() {
        return optionConfirmationService.executeTransTask();
    }

    /**
     * 更新指定记录
     * @param jsonRequest 请求数据
     * @return 是否完成
     */
    @PutMapping(value = "trans", produces = APPLICATION_JSON_VALUE)
    public Boolean modifyOptionConfirmation(@RequestBody JsonRequest jsonRequest) {
        return optionConfirmationService.updateReport(jsonRequest.getId(), jsonRequest.getParams());
    }

    /**
     * 保存指定记录
     * @param jsonRequest 请求数据
     * @return 是否完成
     */
    @PostMapping(value = "excel/prepare", produces = APPLICATION_JSON_VALUE)
    public Boolean saveOptionConfirmation(@RequestBody JsonRequestCollection jsonRequest) {
        return optionConfirmationService.saveReport(jsonRequest.getParams());
    }

    /**
     * 删除指定记录
     * @param bizId 业务编码
     * @return 是否完成
     */
    @GetMapping(value = "trans/{bizId}")
    public Boolean deleteOptionConfirmation(@PathVariable String bizId) {
        return optionConfirmationService.deleteReport(bizId);
    }

    /**
     * 执行report层到xml及zip的生成
     * @param operation 操作标识
     * @return 是否完成
     */
    @PostMapping(value = "generate", produces = APPLICATION_JSON_VALUE)
    public Boolean executeGenerateTask(@RequestParam("operation") String operation) {
        OperationEnum operationEnum = OperationEnum.valueOf(operation);
        String dir = optionConfirmationService.executeGenerateTask(operationEnum);
        //清空xml
        FileUtils.deleteFile(dir);
        return true;
    }
}
