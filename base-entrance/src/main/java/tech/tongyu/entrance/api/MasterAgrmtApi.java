package tech.tongyu.entrance.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.tongyu.core.dto.common.JsonRequest;
import tech.tongyu.core.dto.common.JsonRequestCollection;
import tech.tongyu.core.dto.master.MasterAgrmtDTO;
import tech.tongyu.core.enums.OperationEnum;
import tech.tongyu.core.service.base.MasterAgreementService;
import tech.tongyu.core.utils.FileUtils;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 主协议
 */
@RestController
@RequestMapping("master-agreement")
public class MasterAgrmtApi {

    private final MasterAgreementService masterAgreementService;

    @Autowired
    public MasterAgrmtApi(MasterAgreementService masterAgreementService) {
        this.masterAgreementService = masterAgreementService;
    }

    /**
     * 保存指定记录
     * @param jsonRequest 请求数据
     * @return 是否完成
     */
    @PostMapping(value = "excel/prepare", produces = APPLICATION_JSON_VALUE)
    public Boolean saveMasterAgreement(@RequestBody JsonRequestCollection jsonRequest) {
        return masterAgreementService.saveReport(jsonRequest.getParams());
    }

    /**
     * 查询主协议的report层数据
     * @return 是否完成抽取
     */
    @GetMapping(value = "trans")
    public List<MasterAgrmtDTO> getDataSource() {
        return masterAgreementService.listMasterAgreement();
    }

    /**
     * 执行ods至report层的数据检查和转换
     * @return 是否完成
     */
    @PostMapping(value = "trans", produces = APPLICATION_JSON_VALUE)
    public Boolean executeTransTask() {
        return masterAgreementService.executeTransTask();
    }

    /**
     * 更新指定记录
     * @param jsonRequest 请求数据
     * @return 是否完成
     */
    @PutMapping(value = "trans", produces = APPLICATION_JSON_VALUE)
    public Boolean modifyMasterAgreement(@RequestBody JsonRequest jsonRequest) {
        return masterAgreementService.updateReport(jsonRequest.getId(), jsonRequest.getParams());
    }

    /**
     * 删除指定记录
     * @param bizId 业务编码
     * @return 是否完成
     */
    @GetMapping(value = "trans/{bizId}")
    public Boolean deleteMasterAgreement(@PathVariable String bizId) {
        return masterAgreementService.deleteReport(bizId);
    }

    /**
     * 执行report层到xml及zip的生成
     * @param operation 操作标识
     * @return 是否完成
     */
    @PostMapping(value = "generate", produces = APPLICATION_JSON_VALUE)
    public Boolean executeGenerateTask(@RequestParam("operation") String operation) {
        OperationEnum operationEnum = OperationEnum.valueOf(operation);
        String dir = masterAgreementService.executeGenerateTask(operationEnum);
        //清空xml
        FileUtils.deleteFile(dir);
        return true;
    }
}
