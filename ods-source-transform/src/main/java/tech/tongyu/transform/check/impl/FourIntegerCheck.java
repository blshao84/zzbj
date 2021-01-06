package tech.tongyu.transform.check.impl;

import org.springframework.stereotype.Component;
import tech.tongyu.core.exceptions.TradeCommonException;
import tech.tongyu.transform.check.CheckAction;

import java.util.Map;
import java.util.regex.Pattern;

import static tech.tongyu.core.exceptions.TradeReturnMessage.Errors.FOUR_DIGIT_INTEGER_VALIDATION_FAILED;

/**
 * @Author javier
 * @Description 必须是4位整数通用
 */
@Component
public class FourIntegerCheck implements CheckAction {

    @Override
    public String getCheckName() {
        return "必须是4位整数";
    }

    @Override
    public Object execute(Map<String, Object> data, String elementName) {
        //四位整数正则
        String pattern = "^(0|[1-9]\\d{0,3})$";
        String value = data.get(elementName).toString();
        //必须是4位整数
        if (!Pattern.matches(pattern, value)) {
            throw new TradeCommonException(FOUR_DIGIT_INTEGER_VALIDATION_FAILED, elementName);
        }
        //不足四位在前面补0
        while (value.length() < 4) {
            StringBuffer sb = new StringBuffer();
            sb.append(0).append(value);
            value = sb.toString();
        }
        return value;
    }

    @Override
    public Class<?> getClassType() {
        return String.class;
    }

}
