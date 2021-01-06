package tech.tongyu.transform.check.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import tech.tongyu.core.constant.OptionConfirmationFields;

import java.util.Map;
import java.util.Objects;

/**
 * A1004:
 * <ul>
 *     <li>甲方代签产品名称</li>
 *     <li>甲方代签产品代码</li>
 * </ul>
 *
 * 校验规则：如乙方代签产品名称或乙方代签产品代码填值，则甲方代签产品名称和甲方代签产品代码禁止填值；
 */
@Component
public class PtyAProductExclusiveCheck extends AbstractConditionalExclusiveCheck {
    @Override
    public String getCheckName() {
        return "甲方代签产品禁止填值校验";
    }

    @Override
    public boolean isExclusive(Map<String, Object> data, String elementName) {
        String ptyBProductName = Objects.toString(data.get(OptionConfirmationFields.PTY_B_PDCT_NAME), "");
        String ptyBProductCode = Objects.toString(data.get(OptionConfirmationFields.PYT_B_PDCT_CODE), "");

        if (StringUtils.isNotBlank(ptyBProductCode) || StringUtils.isNotBlank(ptyBProductName)) {
            return true;
        }

        return false;
    }
}
