package tech.tongyu.core.service.base;

import tech.tongyu.core.dto.performance.PerformanceGuaranteeAgrmtDTO;
import tech.tongyu.core.enums.OperationEnum;

import java.util.List;
import java.util.Map;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 履约保证书
 */
public interface PerformanceAgrmtService extends AgreementService {

    /**
     * 查询履约保证书data层数据
     * 注意:
     *   1.获取的是当前最新的data层数据
     * @return data层数据
     */
    List<PerformanceGuaranteeAgrmtDTO> listPerformanceGuaranteeAgrmt();
}
