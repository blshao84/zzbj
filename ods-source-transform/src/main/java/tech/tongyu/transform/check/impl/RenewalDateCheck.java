package tech.tongyu.transform.check.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import tech.tongyu.core.constant.OptionTerminationFields;
import tech.tongyu.core.enums.DurationOperationTypeEnum;
import tech.tongyu.core.exceptions.TradeCommonException;
import tech.tongyu.core.exceptions.TradeReturnMessage;
import tech.tongyu.core.utils.common.DateTimeUtils;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

/**
 * A1006, A1007:
 * 展期日期
 *
 * 校验规则：1、存续期操作类型为展期时必填；2、必须是YYYY-MM-DD；
 */
@Component
public class RenewalDateCheck extends AbstractConditionalRequiredCheck {

    private static final String DATE_PARSE_FORMAT = "yyyy-M-d";
    private static final String DATE_OUT_FORMAT = "yyyy-MM-dd";

    @Override
    public String getCheckName() {
        return "展期日期必填校验";
    }

    @Override
    public Object execute(Map<String, Object> data, String elementName) {
        String value = Objects.toString(super.execute(data, elementName), "");

        if (StringUtils.isBlank(value)) {
            return value;
        }

        LocalDate date = DateTimeUtils.parseDate(value, DATE_PARSE_FORMAT);
        if (date == null) {
            throw new TradeCommonException(TradeReturnMessage.Errors.DATE_VALIDATION_FAILED, elementName);
        }

        return DateTimeUtils.formatDate(date, DATE_OUT_FORMAT);
    }

    @Override
    public boolean isRequired(Map<String, Object> data, String elementName) {
        String durationOperationType = Objects.toString(data.get(OptionTerminationFields.DURATION_OPERATION_TYPE), "");
        return DurationOperationTypeEnum.ROLL.code().equals(durationOperationType);
    }
}
