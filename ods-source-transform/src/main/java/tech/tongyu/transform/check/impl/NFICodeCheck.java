package tech.tongyu.transform.check.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import tech.tongyu.core.constant.MasterAgrmtFileds;
import tech.tongyu.core.enums.PartyTypeEnum;
import tech.tongyu.core.exceptions.TradeCommonException;
import tech.tongyu.core.exceptions.TradeReturnMessage;
import tech.tongyu.transform.check.CheckAction;

import java.util.Map;
import java.util.Objects;

/**
 * A1001: 非金融机构行业代码
 *
 * 校验规则：交易对手方类型为非金融机构时必填；
 */
@Component
public class NFICodeCheck implements CheckAction {
    @Override
    public String getCheckName() {
        return "非金融机构行业代码校验";
    }

    /**
     * 校验规则：交易对手方类型为非金融机构时必填；
     *
     * @param data        传入参数
     * @param elementName 校验元素
     * @return
     */
    @Override
    public Object execute(Map<String, Object> data, String elementName) {
        String value = Objects.toString(data.get(elementName), "");
        String counterpartyType = Objects.toString(data.get(MasterAgrmtFileds.COUNTERPARTY_TYPE), "");
        if (PartyTypeEnum.DOMESTIC_NON_FINANCIAL_INSTITUTIONS.code().equals(counterpartyType)
                || PartyTypeEnum.FOREIGN_NON_FINANCIAL_INSTITUTIONS.code().equals(counterpartyType)) {
            if (StringUtils.isBlank(value)) {
                throw new TradeCommonException(TradeReturnMessage.Errors.NFI_CODE_VALIDATION_FAILED, elementName);
            }
        }
        return value;
    }

    @Override
    public Class<?> getClassType() {
        return String.class;
    }
}
