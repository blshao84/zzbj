package tech.tongyu.transform.check.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import tech.tongyu.core.constant.PeriodicReportSACFields;
import tech.tongyu.core.enums.BusinessTypeEnum;
import tech.tongyu.core.exceptions.TradeCommonException;
import tech.tongyu.core.exceptions.TradeReturnMessage;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

/**
 * A1011:
 * 期权费(非年化)(％)
 *
 * 校验规则：1、如业务类型为期权，需填写本字段，该字段为期权费占名义本金的百分比；2、数值处于0至1之间,保留两位小数；
 */
@Component
public class PeriodReportOptionFeeCheck extends AbstractConditionalRequiredCheck {
    private static final String NUMBER_PATTERN = "^[01](\\.\\d{1,2})?$";

    @Override
    public String getCheckName() {
        return "期权费校验";
    }

    @Override
    public Object execute(Map<String, Object> data, String elementName) {
        String value = Objects.toString(super.execute(data, elementName), "");

        if (StringUtils.isBlank(value)) {
            return value;
        }

        if (!value.matches(NUMBER_PATTERN)) {
            throw new TradeCommonException(TradeReturnMessage.Errors.NUMERICAL_VALIDATION_FAILED, elementName);
        }

        BigDecimal number = new BigDecimal(value);
        number = number.setScale(2);
        BigDecimal maxValue = new BigDecimal("1").setScale(2);
        if (number.compareTo(maxValue) > 0) {
            throw new TradeCommonException(TradeReturnMessage.Errors.MAX_VALUE_VALIDATION_FAILED, "1", elementName);
        }

        return number.toPlainString();
    }

    @Override
    public boolean isRequired(Map<String, Object> data, String elementName) {
        String businessType = Objects.toString(data.get(PeriodicReportSACFields.BUSINESS_TYPE), "");
        return BusinessTypeEnum.OPTION.code().equals(businessType);
    }
}
