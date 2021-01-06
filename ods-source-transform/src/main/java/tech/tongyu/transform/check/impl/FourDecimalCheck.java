package tech.tongyu.transform.check.impl;

import org.springframework.stereotype.Component;
import tech.tongyu.core.exceptions.TradeCommonException;
import tech.tongyu.transform.check.CheckAction;

import java.math.BigDecimal;
import java.util.Map;

import static tech.tongyu.core.exceptions.TradeReturnMessage.Errors.NUMERICAL_VALIDATION_FAILED;

/**
 * @Author javier
 * @Description 保留四位小数校验通用
 */
@Component
public class FourDecimalCheck implements CheckAction {
    @Override
    public String getCheckName() {
        return "保留四位小数";
    }

    @Override
    public Object execute(Map<String, Object> data, String elementName) {
        BigDecimal number = null;
        String value = data.get(elementName).toString();
        try {
            number = new BigDecimal(value);
            return number.setScale(4, BigDecimal.ROUND_HALF_UP);
        } catch (Exception e) {
            throw new TradeCommonException(NUMERICAL_VALIDATION_FAILED, elementName);
        }
    }

    @Override
    public Class<?> getClassType() {
        return String.class;
    }
}
