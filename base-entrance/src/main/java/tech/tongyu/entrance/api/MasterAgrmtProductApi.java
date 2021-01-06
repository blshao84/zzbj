package tech.tongyu.entrance.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.tongyu.core.dto.common.JsonRequest;
import tech.tongyu.core.dto.common.JsonRequestCollection;
import tech.tongyu.core.dto.masterproduct.MasterAgrmtProductDTO;
import tech.tongyu.core.enums.OperationEnum;
import tech.tongyu.core.service.base.MasterAgreementProductService;
import tech.tongyu.core.utils.FileUtils;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 主协议关联产品列表
 */

@RestController
@RequestMapping("master-product-list")
public class MasterAgrmtProductApi {

    private final MasterAgreementProductService masterAgreementProductService;

    @Autowired
    public MasterAgrmtProductApi(MasterAgreementProductService masterAgreementProductService) {
        this.masterAgreementProductService = masterAgreementProductService;
    }

    /**
     * 查询主协议的report层数据
     * @return 是否完成抽取
     */
    @GetMapping(value = "trans")
    public List<MasterAgrmtProductDTO> getDataSource() {
        return masterAgreementProductService.listMasterAgreementProduct();
    }

    /**
     * 执行ods至report层的数据检查和转换
     * @return 是否完成
     */
    @PostMapping(value = "trans", produces = APPLICATION_JSON_VALUE)
    public Boolean executeTransTask() {
        return masterAgreementProductService.executeTransTask();
    }

    /**
     * 保存指定记录
     * @param jsonRequest 请求数据
     * @return 是否完成
     */
    @PostMapping(value = "excel/prepare", produces = APPLICATION_JSON_VALUE)
    public Boolean saveEventReport(@RequestBody JsonRequestCollection jsonRequest) {
        return masterAgreementProductService.saveReport(jsonRequest.getParams());
    }

    /**
     * 更新指定记录
     * @param jsonRequest 请求数据
     * @return 是否完成
     */
    @PutMapping(value = "trans", produces = APPLICATION_JSON_VALUE)
    public Boolean modifyEventReport(@RequestBody JsonRequest jsonRequest) {
        return masterAgreementProductService.updateReport(jsonRequest.getId(), jsonRequest.getParams());
    }

    /**
     * 删除指定记录
     * @param bizId 业务编码
     * @return 是否完成
     */
    @GetMapping(value = "trans/{bizId}")
    public Boolean deleteEventReport(@PathVariable String bizId) {
        return masterAgreementProductService.deleteReport(bizId);
    }

    /**
     * 执行report层到xml及zip的生成
     * @param operation 操作标识
     * @return 是否完成
     */
    @PostMapping(value = "generate", produces = APPLICATION_JSON_VALUE)
    public Boolean executeGenerateTask(@RequestParam("operation") String operation) {
        OperationEnum operationEnum = OperationEnum.valueOf(operation);
        String dir = masterAgreementProductService.executeGenerateTask(operationEnum);
        //清空xml
        FileUtils.deleteFile(dir);
        return true;
    }
}
