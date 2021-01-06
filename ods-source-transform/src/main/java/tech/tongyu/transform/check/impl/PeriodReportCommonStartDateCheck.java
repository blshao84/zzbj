package tech.tongyu.transform.check.impl;

import org.springframework.stereotype.Component;
import tech.tongyu.core.constant.PeriodicReportSACFields;

/**
 * A1011, A1012, A1013
 * 起始日(T日), 起息日
 *
 * 校验规则：必须是YYYY-MM-DD；起始日不能大于到期日
 */
@Component
public class PeriodReportCommonStartDateCheck extends AbstractStartDateCheck {

    @Override
    public String dateOutFormat() {
        return "yyyy-MM-dd";
    }

    @Override
    public String dueDateName() {
        return PeriodicReportSACFields.DUE_DATE;
    }
}
