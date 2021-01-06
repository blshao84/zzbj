package tech.tongyu.transform.check.impl;

import org.springframework.stereotype.Component;
import tech.tongyu.core.constant.OptionConfirmationFields;

/**
 * A1004: 到期日
 *
 * 校验规则：1、到期日不能小于起始日日期；2、必须是YYYY-MM-DD；
 */
@Component
public class OptionDueDateCheck extends AbstractDueDateCheck {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    @Override
    public String getCheckName() {
        return "到期日校验";
    }

    @Override
    public String dateOutFormat() {
        return DATE_FORMAT;
    }

    @Override
    public String startDateName() {
        return OptionConfirmationFields.START_DATE;
    }
}
