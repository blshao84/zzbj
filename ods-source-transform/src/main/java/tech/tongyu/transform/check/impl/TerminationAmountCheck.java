package tech.tongyu.transform.check.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import tech.tongyu.core.constant.OptionTerminationFields;
import tech.tongyu.core.enums.DurationOperationTypeEnum;
import tech.tongyu.core.exceptions.TradeCommonException;
import tech.tongyu.core.exceptions.TradeReturnMessage;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

/**
 * A1006, A1007:
 * 本次终止金额
 *
 * 校验规则：1、当存续期操作类型，选择终止、违约终止时必填；2、保留两位小数；3、选展期时，该字段不能填，否则报送失败。4、大于0且小于等于上次余额；
 */
@Component
public class TerminationAmountCheck extends AbstractConditionalRequiredCheck {
    private static final String NUMBER_PATTERN = "^\\d+(\\.\\d{1,2})?$";

    @Override
    public String getCheckName() {
        return "展期日期必填校验";
    }

    @Override
    public Object execute(Map<String, Object> data, String elementName) {
        String value = Objects.toString(super.execute(data, elementName), "");

        boolean isBlank = StringUtils.isBlank(value);
        String durationOperationType = Objects.toString(data.get(OptionTerminationFields.DURATION_OPERATION_TYPE), "");
        if (DurationOperationTypeEnum.ROLL.code().equals(durationOperationType) && !isBlank) {
            throw new TradeCommonException(TradeReturnMessage.Errors.EXCLUSIVE_VALIDATION_FAILED, elementName);
        }

        if (isBlank) {
            return value;
        }

        if (!value.matches(NUMBER_PATTERN)) {
            throw new TradeCommonException(TradeReturnMessage.Errors.NUMERICAL_VALIDATION_FAILED, elementName);
        }

        BigDecimal number = new BigDecimal(value);
        number = number.setScale(2);

        if (number.compareTo(new BigDecimal("0.00")) <= 0) {
            throw new TradeCommonException(TradeReturnMessage.Errors.MIN_VALUE_VALIDATION_FAILED, "0", elementName);
        }
        return number.toPlainString();
    }

    @Override
    public boolean isRequired(Map<String, Object> data, String elementName) {
        String durationOperationType = Objects.toString(data.get(OptionTerminationFields.DURATION_OPERATION_TYPE), "");
        return DurationOperationTypeEnum.TERMINATION.code().equals(durationOperationType) ||
                DurationOperationTypeEnum.DEFAULT_TERMINATION.code().equals(durationOperationType);
    }
}
