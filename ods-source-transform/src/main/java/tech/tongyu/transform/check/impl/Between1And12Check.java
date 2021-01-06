package tech.tongyu.transform.check.impl;

import org.springframework.stereotype.Component;
import tech.tongyu.core.exceptions.TradeCommonException;
import tech.tongyu.transform.check.CheckAction;

import java.util.Map;
import java.util.regex.Pattern;

import static tech.tongyu.core.exceptions.TradeReturnMessage.Errors.MUST_BE_AN_INTEGER_BETWEEN_ONE_AND_TWELVE_VALIDATION_FAILED;

/**
 * @Author javier
 * @Description 必须是1-12之间的整数校验通用
 */
@Component
public class Between1And12Check implements CheckAction {
    @Override
    public String getCheckName() {
        return "必须是1-12之间的整数";
    }

    @Override
    public Object execute(Map<String, Object> data, String elementName) {

        String pattern = "^([1-9]|1[0-2])$";
        String number = data.get(elementName).toString();
        //必须是1-12之间的整数
        if (!Pattern.matches(pattern, number)) {
            throw new TradeCommonException(MUST_BE_AN_INTEGER_BETWEEN_ONE_AND_TWELVE_VALIDATION_FAILED, elementName);
        }
        return number;
    }

    @Override
    public Class<?> getClassType() {
        return String.class;
    }

}
