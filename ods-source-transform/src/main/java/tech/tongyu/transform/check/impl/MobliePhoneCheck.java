package tech.tongyu.transform.check.impl;

import org.springframework.stereotype.Component;
import tech.tongyu.core.exceptions.TradeCommonException;
import tech.tongyu.transform.check.CheckAction;

import java.util.Map;

import static tech.tongyu.core.exceptions.TradeReturnMessage.Errors.MOBILEPHONE_VALIDATION_FAILED;

/**
 * @author xiayulin
 * - mailto: xiayulin@tongyu.tech
 * @description 校验手机号
 **/
@Component
public class MobliePhoneCheck implements CheckAction {

    // "[1]"代表下一位为数字可以是几，"[0-9]"代表可以为0-9中的一个，"[5,7,9]"表示可以是5,7,9中的任意一位,[^4]表示除4以外的任何一个,
    // \\d{8}"代表后面是可以是0～9的数字，有8位。
    String telRegex = "^((13[0-9])|(14[5,6,7,9])|(15[^4])|(16[5,6])|(17[0-9])|(18[0-9])|(19[1,8,9]))\\d{8}$";


    @Override
    public String getCheckName() {
        return "手机号";
    }

    @Override
    public Object execute(Map<String, Object> data, String elementName) {
        String value = data.get(elementName).toString();
        if (value.matches(telRegex) != true) {
            throw new TradeCommonException(MOBILEPHONE_VALIDATION_FAILED);
        }
        return value;
    }

    @Override
    public Class<?> getClassType() {
        return String.class;
    }

}
