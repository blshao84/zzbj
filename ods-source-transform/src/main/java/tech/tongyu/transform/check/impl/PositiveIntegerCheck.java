package tech.tongyu.transform.check.impl;

import org.springframework.stereotype.Component;
import tech.tongyu.core.exceptions.TradeCommonException;
import tech.tongyu.transform.check.CheckAction;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import static tech.tongyu.core.exceptions.TradeReturnMessage.Errors.POSITIVE_INTEGER_VALIDATION_FAILED;

/**
 * @Author javier
 * @Description 正整数校验通用
 */
@Component
public class PositiveIntegerCheck implements CheckAction {
    @Override
    public String getCheckName() {
        return "正整数";
    }

    @Override
    public Object execute(Map<String, Object> data, String elementName) {
        String pattern = "^[0-9]+$";
        String value = data.get(elementName).toString();
        //正整数
        if (!Pattern.matches(pattern, value)) {
            throw new TradeCommonException(POSITIVE_INTEGER_VALIDATION_FAILED, elementName);
        }
        return value;
    }

    @Override
    public Class<?> getClassType() {
        return String.class;
    }

}
