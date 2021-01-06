package tech.tongyu.transform.check.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import tech.tongyu.core.constant.OptionConfirmationFields;

import java.util.Map;
import java.util.Objects;

/**
 * A1004:
 * <ul>
 *     <li>乙方代签产品名称</li>
 *     <li>乙方代签产品代码</li>
 * </ul>
 *
 * 校验规则：如甲方代签产品名称或甲方代签产品代码填值，则乙方代签产品名称和乙方代签产品代码禁止填值；
 */
@Component
public class PtyBProductExclusiveCheck extends AbstractConditionalExclusiveCheck {
    @Override
    public String getCheckName() {
        return "乙方代签产品禁止填值校验";
    }

    @Override
    public boolean isExclusive(Map<String, Object> data, String elementName) {
        String ptyAProductName = Objects.toString(data.get(OptionConfirmationFields.PTY_A_PDCT_NAME), "");
        String ptyAProductCode = Objects.toString(data.get(OptionConfirmationFields.PYT_A_PDCT_CODE), "");

        if (StringUtils.isNotBlank(ptyAProductName) || StringUtils.isNotBlank(ptyAProductCode)) {
            return true;
        }

        return false;
    }
}
