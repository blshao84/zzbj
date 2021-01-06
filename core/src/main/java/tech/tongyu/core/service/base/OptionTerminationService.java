package tech.tongyu.core.service.base;

import tech.tongyu.core.dto.optiontermination.OptionTerminationDTO;
import tech.tongyu.core.enums.OperationEnum;

import java.util.List;
import java.util.Map;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 期权交易存续期管理
 */
public interface OptionTerminationService extends AgreementService {

    /**
     * 查询期权交易存续期管理data层数据
     * 注意:
     *   1.获取的是当前最新的data层数据
     * @return data层数据
     */
    List<OptionTerminationDTO> listOptionTermination();
}
