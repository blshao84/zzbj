package tech.tongyu.entrance.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.tongyu.core.dto.common.JsonRequest;
import tech.tongyu.core.dto.common.JsonRequestCollection;
import tech.tongyu.core.dto.optiontermination.OptionTerminationDTO;
import tech.tongyu.core.enums.OperationEnum;
import tech.tongyu.core.service.base.OptionTerminationService;
import tech.tongyu.core.utils.FileUtils;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 期权交易存续期管理
 */
@RestController
@RequestMapping("option-termination")
public class OptionTerminationApi {

    private final OptionTerminationService optionTerminationService;

    @Autowired
    public OptionTerminationApi(OptionTerminationService optionTerminationService) {
        this.optionTerminationService = optionTerminationService;
    }

    /**
     * 查询期权交易存续期管理的report层数据
     * @return 是否完成抽取
     */
    @GetMapping(value = "trans")
    public List<OptionTerminationDTO> getDataSource() {
        return optionTerminationService.listOptionTermination();
    }

    /**
     * 执行ods至report层的数据检查和转换
     * @return 是否完成
     */
    @PostMapping(value = "trans", produces = APPLICATION_JSON_VALUE)
    public Boolean executeTransTask() {
        return optionTerminationService.executeTransTask();
    }

    /**
     * 更新指定记录
     * @param jsonRequest 请求数据
     * @return 是否完成
     */
    @PutMapping(value = "trans", produces = APPLICATION_JSON_VALUE)
    public Boolean modifyOptionTermination(@RequestBody JsonRequest jsonRequest) {
        return optionTerminationService.updateReport(jsonRequest.getId(), jsonRequest.getParams());
    }

    /**
     * 保存指定记录
     * @param jsonRequest 请求数据
     * @return 是否完成
     */
    @PostMapping(value = "excel/prepare", produces = APPLICATION_JSON_VALUE)
    public Boolean saveOptionTermination(@RequestBody JsonRequestCollection jsonRequest) {
        return optionTerminationService.saveReport(jsonRequest.getParams());
    }

    /**
     * 删除指定记录
     * @param bizId 业务编码
     * @return 是否完成
     */
    @GetMapping(value = "trans/{bizId}")
    public Boolean deleteOptionTermination(@PathVariable String bizId) {
        return optionTerminationService.deleteReport(bizId);
    }

    /**
     * 执行report层到xml及zip的生成
     * @param operation 操作标识
     * @return 是否完成
     */
    @PostMapping(value = "generate", produces = APPLICATION_JSON_VALUE)
    public Boolean executeGenerateTask(@RequestParam("operation") String operation) {
        OperationEnum operationEnum = OperationEnum.valueOf(operation);
        String dir = optionTerminationService.executeGenerateTask(operationEnum);
        //清空xml
        FileUtils.deleteFile(dir);
        return true;
    }
}
