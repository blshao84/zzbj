package tech.tongyu.core.service.base;

import tech.tongyu.core.dto.optionconfirmation.OptionConfirmationDTO;
import tech.tongyu.core.enums.OperationEnum;

import java.util.List;
import java.util.Map;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 期权交易确认书
 */
public interface OptionConfirmationService extends AgreementService {

    /**
     * 查询期权交易确认书data层数据
     * 注意:
     *   1.获取的是当前最新的data层数据
     * @return data层数据
     */
    List<OptionConfirmationDTO> listOptionConfirmation();
}
