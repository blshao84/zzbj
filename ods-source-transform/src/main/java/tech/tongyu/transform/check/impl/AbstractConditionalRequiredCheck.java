package tech.tongyu.transform.check.impl;

import org.apache.commons.lang3.StringUtils;
import tech.tongyu.core.exceptions.TradeCommonException;
import tech.tongyu.core.exceptions.TradeReturnMessage;
import tech.tongyu.transform.check.CheckAction;

import java.util.Map;
import java.util.Objects;

/**
 * 条件式校验
 *
 * 满足特定条件时，字段必填
 */
public abstract class AbstractConditionalRequiredCheck implements CheckAction {

    @Override
    public String getCheckName() {
        return "条件式必填校验";
    }

    @Override
    public Object execute(Map<String, Object> data, String elementName) {
        String value = Objects.toString(data.get(elementName), "");
        if (isRequired(data, elementName) && StringUtils.isBlank(value)) {
            throw new TradeCommonException(TradeReturnMessage.Errors.REQUIRED_VALIDATION_FAILED, elementName);
        }

        return value;
    }

    @Override
    public Class<?> getClassType() {
        return String.class;
    }

    /**
     * 判断字段是否必填
     *
     * @param data
     * @param elementName
     * @return
     */
    public abstract boolean isRequired(Map<String, Object> data, String elementName);
}
