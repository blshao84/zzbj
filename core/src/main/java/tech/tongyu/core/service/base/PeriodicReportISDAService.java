package tech.tongyu.core.service.base;

import tech.tongyu.core.dto.isda.PeriodicReportISDADTO;
import tech.tongyu.core.enums.OperationEnum;

import java.util.List;
import java.util.Map;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description ISDA
 */
public interface PeriodicReportISDAService extends AgreementService {

    /**
     * 查询ISDAdata层数据
     * 注意:
     *   1.获取的是当前最新的data层数据
     * @return data层数据
     */
    List<PeriodicReportISDADTO> listPeriodicReportISDA();
}
