package tech.tongyu.transform.check.impl;

import org.springframework.stereotype.Component;
import tech.tongyu.core.exceptions.TradeCommonException;
import tech.tongyu.transform.check.CheckAction;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static tech.tongyu.core.exceptions.TradeReturnMessage.Errors.NUMERICAL_VALIDATION_FAILED;
import static tech.tongyu.core.exceptions.TradeReturnMessage.Errors.THE_TOTAL_LENGTH_CANNOT_EXCEED_TWENTY_VALIDATION_FAILED2;

/**
 * @Author javier
 * @Description 保留2位小数, 同时总的字符长度不能超过20, 即整数位最多可为18位；
 */
@Component
public class TwoDecimal20LenCheck implements CheckAction {


    @Override
    public String getCheckName() {
        return "保留2位小数,同时总的字符长度不能超过20,即整数位最多可为18位";
    }

    @Override
    public Object execute(Map<String, Object> data, String elementName) {
        BigDecimal number = null;
        String value = data.get(elementName).toString();
        //保留2位小数
        try {
            number = new BigDecimal(value);
            number = number.setScale(2, BigDecimal.ROUND_HALF_UP);
        } catch (Exception e) {
            throw new TradeCommonException(NUMERICAL_VALIDATION_FAILED, elementName);
        }
        //总长度不能超过20
        if (number.toString().length() > 20) {
            throw new TradeCommonException(THE_TOTAL_LENGTH_CANNOT_EXCEED_TWENTY_VALIDATION_FAILED2, elementName);
        }
        return number;
    }

    @Override
    public Class<?> getClassType() {
        return String.class;
    }

}
