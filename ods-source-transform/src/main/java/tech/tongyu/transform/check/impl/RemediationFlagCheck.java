package tech.tongyu.transform.check.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import tech.tongyu.core.constant.MasterAgrmtFileds;
import tech.tongyu.core.enums.RemediationEnum;
import tech.tongyu.core.exceptions.TradeCommonException;
import tech.tongyu.core.exceptions.TradeReturnMessage;
import tech.tongyu.transform.check.CheckAction;

import java.util.Map;
import java.util.Objects;

/**
 * 通用校验
 * 校验规则：首次提交时填0，补正时填1
 *
 * @author xiayulin
 */
@Component
public class RemediationFlagCheck implements CheckAction {

    @Override
    public String getCheckName() {
        return "首次提交时填0，补正时填1";
    }

    @Override
    public Object execute(Map<String, Object> data, String elementName) {
        String BizID = Objects.toString(data.get(MasterAgrmtFileds.BIZ_ID));
        String value = Objects.toString(data.get(elementName));
        if (StringUtils.isBlank(BizID)) {
            if (RemediationEnum.UPDATE.code().equals(value)) {
                throw new TradeCommonException(TradeReturnMessage.Errors.REMEDIATION_VALIDATION_FAILED, elementName);
            }
        } else {
            if (RemediationEnum.ADD.code().equals(value)) {
                throw new TradeCommonException(TradeReturnMessage.Errors.REMEDIATION_VALIDATION_FAILED, elementName);
            }
        }

        return value;
    }

    @Override
    public Class<?> getClassType() {
        return null;
    }
}
