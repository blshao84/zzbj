package tech.tongyu.transform.check.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import tech.tongyu.core.constant.MasterAgrmtFileds;

import java.util.Map;
import java.util.Objects;

/**
 * 通用校验
 * 校验规则：补正时必填
 * @author xiayulin
 */
@Component
public class RemediationCheck extends AbstractConditionalRequiredCheck {

    @Override
    public String getCheckName() {
        return "补正时必填";
    }

    @Override
    public boolean isRequired(Map<String, Object> data, String elementName) {

        String BizID = Objects.toString(data.get(MasterAgrmtFileds.BIZ_ID));
        return StringUtils.isNotBlank(BizID);
    }
}
