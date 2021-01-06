package tech.tongyu.core.service.base;

import tech.tongyu.core.dto.quarter.PeriodicReportQuarterDTO;
import tech.tongyu.core.enums.OperationEnum;

import java.util.List;
import java.util.Map;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 定期报告-季报
 */
public interface PeriodicReportQuarterService extends AgreementService {

    /**
     * 查询Quarterdata层数据
     * 注意:
     *   1.获取的是当前最新的data层数据
     * @return data层数据
     */
    List<PeriodicReportQuarterDTO> listPeriodicReportQuarter();
}
