package tech.tongyu.transform.check.impl;

import org.springframework.stereotype.Component;
import tech.tongyu.core.constant.OptionConfirmationFields;

/**
 * A1004: 起始日
 *
 * 校验规则：1、起始日不能大于到期日日期；2、必须是YYYY-MM-DD；
 */
@Component
public class OptionStartDateCheck extends AbstractStartDateCheck {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    @Override
    public String getCheckName() {
        return "起始日校验";
    }

    @Override
    public String dateOutFormat() {
        return DATE_FORMAT;
    }

    @Override
    public String dueDateName() {
        return OptionConfirmationFields.DUE_DATE;
    }
}
