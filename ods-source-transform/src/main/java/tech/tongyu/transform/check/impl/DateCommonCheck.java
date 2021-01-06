package tech.tongyu.transform.check.impl;

import org.springframework.stereotype.Component;
import tech.tongyu.core.exceptions.TradeCommonException;
import tech.tongyu.transform.check.CheckAction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import static tech.tongyu.core.exceptions.TradeReturnMessage.Errors.DATE_VALIDATION_FAILED;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 日期通用
 **/
@Component
public class DateCommonCheck implements CheckAction {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public String getCheckName() {
        return "YYYY-MM-DD日期校验";
    }

    @Override
    public Object execute(Map<String, Object> data, String elementName) {
        Date format = null;
        String date = data.get(elementName).toString();
        try {
            format = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            throw new TradeCommonException(DATE_VALIDATION_FAILED, elementName);
        }
        return new SimpleDateFormat("yyyy-MM-dd").format(format);
    }

    @Override
    public Class<?> getClassType() {
        return String.class;
    }

}
