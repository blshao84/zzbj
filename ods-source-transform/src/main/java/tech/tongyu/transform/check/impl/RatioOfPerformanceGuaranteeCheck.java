package tech.tongyu.transform.check.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;
import tech.tongyu.core.exceptions.TradeCommonException;
import tech.tongyu.core.exceptions.TradeReturnMessage;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

/**
 * A1004:
 * <ul>
 * <li>履约担保品初始比率（%）</li>
 * <li>履约担保品追保比率（%）</li>
 * <li>履约担保品平仓比率（%）</li>
 * </ul>
 *
 *
 * 校验规则：1、当履约保障类型选择部分担保或全额担保时必填；
 * 2、请输入0到100之间的最多2位小数的数字。；
 */
@Component
public class RatioOfPerformanceGuaranteeCheck extends RequiredOnPerformanceGuaranteeTypeCheck {

    private static final String NUMBER_PATTERN = "^\\d{1,3}(\\.\\d{1,2})?$";

    @Override
    public String getCheckName() {
        return "履约担保相关利率校验";
    }

    @Override
    public Object execute(Map<String, Object> data, String elementName) {
        String value = Objects.toString(super.execute(data, elementName));

        if (StringUtils.isBlank(value)) {
            return Strings.EMPTY;
        }

        if (value.matches(NUMBER_PATTERN)) {
            BigDecimal number = new BigDecimal(value);
            if (number.setScale(2).compareTo(new BigDecimal("100.00").setScale(2)) > 0) {
                throw new TradeCommonException(TradeReturnMessage.Errors.RATIO_VALUE_VALIDATION_FAILED);
            }
        } else {
            throw new TradeCommonException(TradeReturnMessage.Errors.RATIO_VALUE_VALIDATION_FAILED);
        }

        return value;
    }

    @Override
    public Class<?> getClassType() {
        return String.class;
    }
}
