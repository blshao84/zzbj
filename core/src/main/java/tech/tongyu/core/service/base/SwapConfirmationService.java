package tech.tongyu.core.service.base;

import tech.tongyu.core.dto.swapconfirmation.SwapConfirmationDTO;
import tech.tongyu.core.enums.OperationEnum;

import java.util.List;
import java.util.Map;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 互换交易确认书
 */
public interface SwapConfirmationService extends AgreementService {

    /**
     * 查询互换交易确认书data层数据
     * 注意:
     *   1.获取的是当前最新的data层数据
     * @return data层数据
     */
    List<SwapConfirmationDTO> listSwapConfirmation();
}
