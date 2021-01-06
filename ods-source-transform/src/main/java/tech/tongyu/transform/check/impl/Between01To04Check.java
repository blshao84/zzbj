package tech.tongyu.transform.check.impl;

import org.springframework.stereotype.Component;
import tech.tongyu.core.exceptions.TradeCommonException;
import tech.tongyu.core.exceptions.TradeReturnMessage;
import tech.tongyu.transform.check.CheckAction;

import java.util.Map;
import java.util.Objects;

/**
 * 通用校验
 * 校验规则：必须是01-04之间；
 *
 * @author xiayulin
 */
@Component
public class Between01To04Check implements CheckAction {

    static final String NUMBER_LIST = "01,02,03,04";

    @Override
    public String getCheckName() {
        return "必须是01-04之间";
    }

    @Override
    public Object execute(Map<String, Object> data, String elementName) {
        String value = Objects.toString(data.get(elementName));
        if (!value.matches(NUMBER_LIST)) {
            throw new TradeCommonException(TradeReturnMessage.Errors.BETWEEN01TO04_VALIDATION_FAILED);
        }
        return value;
    }

    @Override
    public Class<?> getClassType() {
        return null;
    }
}
