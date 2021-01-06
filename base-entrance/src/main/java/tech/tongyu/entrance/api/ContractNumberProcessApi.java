package tech.tongyu.entrance.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.tongyu.core.dto.common.JsonRequest;
import tech.tongyu.core.dto.common.JsonRequestCollection;
import tech.tongyu.core.dto.contract.ContractNumberProcessDTO;
import tech.tongyu.core.enums.OperationEnum;
import tech.tongyu.core.service.base.ContractNumberProcessService;
import tech.tongyu.core.utils.FileUtils;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 双方约定编号数据处理
 */
@RestController
@RequestMapping("/contract-number")
public class ContractNumberProcessApi {

    private final ContractNumberProcessService contractNumberProcessService;

    @Autowired
    public ContractNumberProcessApi(ContractNumberProcessService contractNumberProcessService) {
        this.contractNumberProcessService = contractNumberProcessService;
    }

    /**
     * 查询双方约定编号数据处理的report层数据
     * @return 是否完成抽取
     */
    @GetMapping(value = "trans")
    public List<ContractNumberProcessDTO> getDataSource() {
        return contractNumberProcessService.listContractNumberProcess();
    }

    /**
     * 执行ods至report层的数据检查和转换
     * @return 是否完成
     */
    @PostMapping(value = "trans", produces = APPLICATION_JSON_VALUE)
    public Boolean executeTransTask() {
        contractNumberProcessService.executeTransTask();
        return Boolean.TRUE;
    }

    /**
     * 更新指定记录
     * @return 是否完成
     * @param jsonRequest 请求数据
     */
    @PutMapping(value = "trans", produces = APPLICATION_JSON_VALUE)
    public Boolean modifyContractNumberProcess(@RequestBody JsonRequest jsonRequest) {
        return contractNumberProcessService.updateReport(jsonRequest.getId(), jsonRequest.getParams());
    }

    /**
     * 保存指定记录
     * @return 是否完成
     * @param jsonRequest 请求数据
     */
    @PostMapping(value = "excel/prepare", produces = APPLICATION_JSON_VALUE)
    public Boolean savePeriodicReportQuarter(@RequestBody JsonRequestCollection jsonRequest) {
        return contractNumberProcessService.saveReport(jsonRequest.getParams());
    }

    /**
     * 删除指定记录
     * @param bizId 业务编码
     * @return 是否完成
     */
    @GetMapping(value = "trans/{bizId}")
    public Boolean deleteContractNumberProcess(@PathVariable String bizId) {
        return contractNumberProcessService.deleteReport(bizId);
    }

    /**
     * 执行report层到xml及zip的生成
     * @param operation 操作标识
     * @return 是否完成
     */
    @PostMapping(value = "generate", produces = APPLICATION_JSON_VALUE)
    public Boolean executeGenerateTask(@RequestParam("operation") String operation) {
        OperationEnum operationEnum = OperationEnum.valueOf(operation);
        String dir = contractNumberProcessService.executeGenerateTask(operationEnum);
        //清空xml
        FileUtils.deleteFile(dir);
        return true;
    }

}
