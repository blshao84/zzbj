package tech.tongyu.transform.check.impl;

import org.springframework.stereotype.Component;
import tech.tongyu.core.constant.PeriodicReportNAFMIIFields;

/**
 * A1012
 * 到期日
 *
 * 校验规则：必须是YYYY-MM-DD；到期日不能小于起息日
 */
@Component
public class NAFMIIDueDateCheck extends AbstractDueDateCheck {

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
        return PeriodicReportNAFMIIFields.DALUE_DATE;
    }
}
