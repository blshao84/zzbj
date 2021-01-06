package tech.tongyu.transform.check.impl;

import org.springframework.stereotype.Component;
import tech.tongyu.core.constant.PeriodicReportSACFields;

/**
 * A1011, A1013
 * 到期日
 *
 * 校验规则：1、到期日不能小于起始日日期；2、必须是YYYY-MM-DD；
 */
@Component
public class PeriodReportCommonDueDateCheck extends AbstractDueDateCheck {

    @Override
    public String getCheckName() {
        return "到期日校验";
    }

    @Override
    public String dateOutFormat() {
        return "yyyy-MM-dd";
    }

    @Override
    public String startDateName() {
        return PeriodicReportSACFields.STARTING_DAY;
    }
}
