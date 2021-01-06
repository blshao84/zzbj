package tech.tongyu.transform.check.impl;

import org.springframework.stereotype.Component;
import tech.tongyu.core.exceptions.TradeCommonException;
import tech.tongyu.transform.check.CheckAction;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import static tech.tongyu.core.exceptions.TradeReturnMessage.Errors.MUST_BE_WITHIN_TWO_DECIMAL_PLACES_VALIDATION_FAILED;

/**
 * @Author javier
 * @Description 必须两位小数以内
 */
@Component
public class Within2DecimalCheck implements CheckAction {

    @Override
    public String getCheckName() {
        return "必须两位小数以内";
    }

    @Override
    public Object execute(Map<String, Object> data, String elementName) {
        //两位小数以内正则
        String pattern = "^(([0-9]+\\d*)|([0-9]+\\d*\\.\\d{1,2}))$";
        String value = data.get(elementName).toString();
        //必须两位小数以内
        if (!Pattern.matches(pattern, value)) {
            throw new TradeCommonException(MUST_BE_WITHIN_TWO_DECIMAL_PLACES_VALIDATION_FAILED, elementName);
        }
        return value;
    }

    @Override
    public Class<?> getClassType() {
        return String.class;
    }
}
