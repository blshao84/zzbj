package tech.tongyu.transform.check.impl;

import org.springframework.stereotype.Component;
import tech.tongyu.core.exceptions.TradeCommonException;
import tech.tongyu.transform.check.CheckAction;

import java.util.Map;
import java.util.regex.Pattern;

import static tech.tongyu.core.exceptions.TradeReturnMessage.Errors.ONLY_PDF_FORMAT_IS_SUPPORTED_VALIDATION_FAILED;

/**
 * @Author javier
 * @Description 只支持PDF格式校验通用
 */
@Component
public class PdfFormatIsCheck implements CheckAction {

    @Override
    public String getCheckName() {
        return "只支持PDF格式";
    }

    @Override
    public Object execute(Map<String, Object> data, String elementName) {
        //PDF格式正则
        String pattern = ".*(.(?i)pdf)$";
        String value = data.get(elementName).toString();
        if (!Pattern.matches(pattern, value)) {
            throw new TradeCommonException(ONLY_PDF_FORMAT_IS_SUPPORTED_VALIDATION_FAILED, elementName);
        }
        return value;
    }

    @Override
    public Class<?> getClassType() {
        return String.class;
    }

}
