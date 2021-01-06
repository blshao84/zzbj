package tech.tongyu.core.service.base;

import tech.tongyu.core.dto.contract.ContractNumberProcessDTO;
import tech.tongyu.core.enums.OperationEnum;

import java.util.List;
import java.util.Map;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 双方约定编号数据处理
 */
public interface ContractNumberProcessService extends AgreementService {

    /**
     * 查询双方约定编号数据处理data层数据
     * 注意:
     *   1.获取的是当前最新的data层数据
     * @return data层数据
     */
    List<ContractNumberProcessDTO> listContractNumberProcess();
}
