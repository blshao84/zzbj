package tech.tongyu.transform.check.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import tech.tongyu.core.constant.OptionConfirmationFields;
import tech.tongyu.core.enums.OptionStructureTypeEnum;
import tech.tongyu.core.exceptions.TradeCommonException;
import tech.tongyu.core.exceptions.TradeReturnMessage;
import tech.tongyu.transform.check.CheckAction;

import java.util.Map;
import java.util.Objects;

/**
 * A1004: 期权结构
 *
 * 校验规则：“期权结构类型”选择为其他时，为必填；
 */
@Component
public class OptionStructureCheck implements CheckAction {

    @Override
    public String getCheckName() {
        return "期权结构校验";
    }

    @Override
    public Object execute(Map<String, Object> data, String elementName) {
        String value = Objects.toString(data.get(elementName), "");
        String optionStructureType = Objects.toString(data.get(OptionConfirmationFields.OPTION_STRUCTURE_TYPE), "");
        if (OptionStructureTypeEnum.OTHER.code().equals(optionStructureType)) {
            if (StringUtils.isBlank(value)) {
                throw new TradeCommonException(TradeReturnMessage.Errors.OPTION_STRUCTURE_VALIDATION_FAILED, elementName);
            }
        }
        return value;
    }

    @Override
    public Class<?> getClassType() {
        return null;
    }
}
