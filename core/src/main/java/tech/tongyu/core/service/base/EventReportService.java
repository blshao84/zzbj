package tech.tongyu.core.service.base;

import tech.tongyu.core.dto.event.EventReportDTO;
import tech.tongyu.core.enums.OperationEnum;

import java.util.List;
import java.util.Map;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 重大事件报告
 **/
public interface EventReportService extends AgreementService {

    /**
     * 查询重大事件报告data层数据
     * 注意:
     *   1.获取的是当前最新的data层数据
     * @return data层数据
     */
    List<EventReportDTO> listEventReport();
}
