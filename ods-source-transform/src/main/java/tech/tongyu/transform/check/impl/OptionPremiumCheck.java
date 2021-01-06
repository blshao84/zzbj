package tech.tongyu.transform.check.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import tech.tongyu.core.exceptions.TradeCommonException;
import tech.tongyu.core.exceptions.TradeReturnMessage;
import tech.tongyu.transform.check.CheckAction;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

/**
 * A1004: 期权费(非年化)%
 *
 * 校验规则：1、数值处于0至1之间且最多两位小数；2、百分比处于0至100之间整数带%；
 */
@Component
public class OptionPremiumCheck implements CheckAction {

    private static final String PERCENT_PATTERN = "^\\d{1,3}%$";
    private static final String NUMBER_PATTERN = "^[01](\\.\\d{1,2})?$";

    private static final BigDecimal ONE = new BigDecimal("1.00");

    @Override
    public String getCheckName() {
        return "期权费校验";
    }

    @Override
    public Object execute(Map<String, Object> data, String elementName) {
        String value = Objects.toString(data.get(elementName), "");
        if (StringUtils.isBlank(value)) {
            throw new TradeCommonException(TradeReturnMessage.Errors.REQUIRED_VALIDATION_FAILED, elementName);
        }

        if (value.matches(PERCENT_PATTERN)) {
            // 百分比格式
            String numberStr = value.substring(0, value.length() - 1);
            int number = Integer.parseInt(numberStr);
            if (!(number >= 0 && number <= 100)) {
                throw new TradeCommonException(TradeReturnMessage.Errors.OPTION_PREMIUM_VALIDATION_FAILED);
            }
        } else if (value.matches(NUMBER_PATTERN)) {
            // 数值格式
            BigDecimal numberValue = new BigDecimal(value);
            numberValue = numberValue.setScale(2);
            if (numberValue.compareTo(ONE) > 0) {
                throw new TradeCommonException(TradeReturnMessage.Errors.OPTION_PREMIUM_VALIDATION_FAILED);
            }
        } else {
            throw new TradeCommonException(TradeReturnMessage.Errors.OPTION_PREMIUM_VALIDATION_FAILED);
        }

        return value;
    }

    @Override
    public Class<?> getClassType() {
        return String.class;
    }
}
