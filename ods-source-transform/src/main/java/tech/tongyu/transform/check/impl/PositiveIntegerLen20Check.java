package tech.tongyu.transform.check.impl;

import org.springframework.stereotype.Component;
import tech.tongyu.core.exceptions.TradeCommonException;
import tech.tongyu.transform.check.CheckAction;

import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

import static tech.tongyu.core.exceptions.TradeReturnMessage.Errors.POSITIVE_INTEGER_VALIDATION_FAILED;
import static tech.tongyu.core.exceptions.TradeReturnMessage.Errors.THE_TOTAL_LENGTH_CANNOT_EXCEED_TWENTY_VALIDATION_FAILED1;

/**
 * 通用校验
 * 校验规则：正整数，长度介于0和20之间；
 *
 * @author xiayulin
 */
@Component
public class PositiveIntegerLen20Check implements CheckAction {

    static final int LENGTH_OF_VALUE = 20;

    @Override
    public String getCheckName() {
        return "正整数";
    }

    @Override
    public Object execute(Map<String, Object> data, String elementName) {
        String pattern = "^[0-9]+$";
        String value = Objects.toString(data.get(elementName));
        if (!Pattern.matches(pattern, value)) {
            throw new TradeCommonException(POSITIVE_INTEGER_VALIDATION_FAILED, elementName);
        }
        if (value.length() > LENGTH_OF_VALUE) {
            throw new TradeCommonException(THE_TOTAL_LENGTH_CANNOT_EXCEED_TWENTY_VALIDATION_FAILED1, elementName);
        }
        return value;
    }

    @Override
    public Class<?> getClassType() {
        return String.class;
    }
}
