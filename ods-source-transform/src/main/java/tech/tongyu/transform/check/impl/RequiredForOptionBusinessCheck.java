package tech.tongyu.transform.check.impl;

import org.springframework.stereotype.Component;
import tech.tongyu.core.constant.PeriodicReportSACFields;
import tech.tongyu.core.enums.BusinessTypeEnum;

import java.util.Map;
import java.util.Objects;

/**
 * A1011:
 * <ul>
 *     <li>期权标的小类(场外期权填写)</li>
 *     <li>期权类型(期权填写)</li>
 * </ul>
 *
 * 校验规则：如业务类型为期权，需填写本字段；
 */
@Component
public class RequiredForOptionBusinessCheck extends AbstractConditionalRequiredCheck {

    @Override
    public String getCheckName() {
        return "期权业务类型字段必填校验";
    }

    @Override
    public boolean isRequired(Map<String, Object> data, String elementName) {
        String businessType = Objects.toString(data.get(PeriodicReportSACFields.BUSINESS_TYPE), "");
        return BusinessTypeEnum.OPTION.code().equals(businessType);
    }
}
