package tech.tongyu.core.service.base;

import tech.tongyu.core.dto.other.OtherReportDTO;
import tech.tongyu.core.enums.OperationEnum;

import java.util.List;
import java.util.Map;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 其他事件报告
 */
public interface OtherReportService extends AgreementService {

    /**
     * 查询其他事件报告data层数据
     * 注意:
     *   1.获取的是当前最新的data层数据
     * @return data层数据
     */
    List<OtherReportDTO> listOtherReport();
}
