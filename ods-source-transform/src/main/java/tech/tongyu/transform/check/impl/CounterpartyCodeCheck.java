package tech.tongyu.transform.check.impl;

import org.springframework.stereotype.Component;
import tech.tongyu.core.constant.MasterAgrmtFileds;
import tech.tongyu.core.enums.PartyTypeEnum;
import tech.tongyu.core.exceptions.TradeCommonException;
import tech.tongyu.core.exceptions.TradeReturnMessage;
import tech.tongyu.transform.check.CheckAction;

import java.util.Map;
import java.util.Objects;

/**
 * A1001: 交易对手方组织机构代码
 *
 * 校验规则：1、必须为8、9、10或18位；、2、当交易对手方类型是境外金融机构、境外非金融机构，必填00000000；
 *
 */
@Component
public class CounterpartyCodeCheck implements CheckAction {

    @Override
    public String getCheckName() {
        return "交易对手方组织机构代码校验";
    }

    /**
     * 校验规则：1、必须为8、9、10或18位；、2、当交易对手方类型是境外金融机构、境外非金融机构，必填00000000；
     *
     * CounterpartyType: 境外金融机构|14、境外非金融机构|15
     *
     * @param data        传入参数
     * @param elementName 校验元素
     * @return
     */
    @Override
    public Object execute(Map<String, Object> data, String elementName) {
        String value = Objects.toString(data.get(elementName), "");
        String counterpartyType = Objects.toString(data.get(MasterAgrmtFileds.COUNTERPARTY_TYPE), "");

        if (PartyTypeEnum.FOREIGN_FINANCIAL_INSTITUTIONS.code().equals(counterpartyType)
                || PartyTypeEnum.FOREIGN_NON_FINANCIAL_INSTITUTIONS.code().equals(counterpartyType)) {
            if (!"00000000".equals(value)) {
                throw new TradeCommonException(TradeReturnMessage.Errors.COUNTERPARTY_CODE_FOR_FOREIGN_VALIDATION_FAILED, elementName);
            }
        } else {
            int length = value.length();
            if (!(length == 8 || length == 9 || length == 10 || length == 18)) {
                throw new TradeCommonException(TradeReturnMessage.Errors.COUNTERPARTY_CODE_COMMON_VALIDATION_FAILED, elementName);
            }
        }
        return value;
    }

    @Override
    public Class<?> getClassType() {
        return String.class;
    }
}
