package tech.tongyu.transform.check.impl;

import org.springframework.stereotype.Component;
import tech.tongyu.core.constant.OptionConfirmationFields;
import tech.tongyu.core.enums.PerformanceGuaranteeTypeEnum;

import java.util.Map;
import java.util.Objects;

/**
 * A1004:
 * <ul>
 * <li>履约担保品提供方</li>
 * <li>担保品收取方是否可使用担保品</li>
 * <li>担保品使用说明</li>
 * <li>是否计算担保品价值产生利息</li>
 * </ul>
 *
 * 校验规则：当履约保障类型选择部分担保或全额担保时必填；
 */
@Component
public class RequiredOnPerformanceGuaranteeTypeCheck extends AbstractConditionalRequiredCheck {

    @Override
    public String getCheckName() {
        return "履约担保必填字段校验";
    }

    @Override
    public boolean isRequired(Map<String, Object> data, String elementName) {
        String performanceGuaranteeType = Objects.toString(data.get(OptionConfirmationFields.PERFORMANCE_GUARANTEE_TYPE), "");

        return (PerformanceGuaranteeTypeEnum.PARTIAL.code().equals(performanceGuaranteeType)
                || PerformanceGuaranteeTypeEnum.FULL.code().equals(performanceGuaranteeType));
    }
}
