package tech.tongyu.transform.check.impl;

import org.springframework.stereotype.Component;
import tech.tongyu.core.constant.OptionTerminationFields;
import tech.tongyu.core.enums.DurationOperationTypeEnum;

import java.util.Map;
import java.util.Objects;

/**
 * A1006, A1007
 * <ul>
 *     <li>违约方</li>
 *     <li>违约事件说明</li>
 * </ul>
 * 校验规则：存续期操作类型为违约终止时必填；
 */
@Component
public class RequiredForDefaultTerminationCheck extends AbstractConditionalRequiredCheck {
    @Override
    public String getCheckName() {
        return "违约字段必填校验";
    }

    @Override
    public boolean isRequired(Map<String, Object> data, String elementName) {
        String durationOperationType = Objects.toString(data.get(OptionTerminationFields.DURATION_OPERATION_TYPE), "");
        return DurationOperationTypeEnum.DEFAULT_TERMINATION.code().equals(durationOperationType);
    }
}
