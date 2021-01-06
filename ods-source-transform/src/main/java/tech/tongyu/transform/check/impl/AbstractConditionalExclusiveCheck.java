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
 * 满足特定条件时，字段禁止填值
 */
public abstract class AbstractConditionalExclusiveCheck implements CheckAction {
    @Override
    public String getCheckName() {
        return "条件式禁止填值校验";
    }

    @Override
    public Object execute(Map<String, Object> data, String elementName) {
        String value = Objects.toString(data.get(elementName), "");
        if (isExclusive(data, elementName) && StringUtils.isNotBlank(value)) {
            throw new TradeCommonException(TradeReturnMessage.Errors.EXCLUSIVE_VALIDATION_FAILED, elementName);
        }

        return value;
    }

    @Override
    public Class<?> getClassType() {
        return String.class;
    }

    /**
     * 判断字段是否禁止填值
     *
     * @param data
     * @param elementName
     * @return
     */
    public abstract boolean isExclusive(Map<String, Object> data, String elementName);
}
