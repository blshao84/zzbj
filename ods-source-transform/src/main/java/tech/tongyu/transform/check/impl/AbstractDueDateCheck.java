package tech.tongyu.transform.check.impl;

import org.apache.commons.lang3.StringUtils;
import tech.tongyu.core.exceptions.TradeCommonException;
import tech.tongyu.core.exceptions.TradeReturnMessage;
import tech.tongyu.core.utils.common.DateTimeUtils;
import tech.tongyu.transform.check.CheckAction;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

/**
 * 到期日期校验
 * <p>
 * 校验规则：
 * 1. 起始日期和到期日期必填；
 * 2. 符合一定格式
 * 3. 到期日不能小于起始日期
 */
public abstract class AbstractDueDateCheck implements CheckAction {

    @Override
    public String getCheckName() {
        return "到期日期校验";
    }

    @Override
    public Object execute(Map<String, Object> data, String elementName) {
        String dueDateValue = Objects.toString(data.get(elementName), "");
        String dateFormat = dateParseFormat();
        LocalDate dueDate = parseDate(dueDateValue, dateFormat, elementName);
        LocalDate startDate = getStartDate(data, elementName);
        if (dueDate.isBefore(startDate)) {
            throw new TradeCommonException(TradeReturnMessage.Errors.START_DUE_DATE_VALIDATION_FAILED, elementName);
        }
        return DateTimeUtils.formatDate(dueDate, dateOutFormat());
    }

    @Override
    public Class<?> getClassType() {
        return String.class;
    }

    /**
     * 输入日期格式， 默认"yyyy-M-d"， 匹配 2020-01-01， 2020-1-1
     *
     * @return
     */
    public String dateParseFormat() {
        return "yyyy-M-d";
    }

    /**
     * 输出日期格式， 默认"yyyy-MM-dd"
     *
     * @return
     */
    public String dateOutFormat() {
        return "yyyy-MM-dd";
    }

    /**
     * Start date 字段名
     *
     * @return
     */
    public abstract String startDateName();

    /**
     * 解析获取到期日期
     *
     * @param data 数据集
     * @return
     */
    public LocalDate getStartDate(Map<String, Object> data, String elementName) {
        String startDateName = startDateName();
        String value = Objects.toString(data.get(startDateName), "");
        return parseDate(value, dateParseFormat(), startDateName);
    }

    protected LocalDate parseDate(String value, String format, String elementName) {
        if (StringUtils.isBlank(value)) {
            throw new TradeCommonException(TradeReturnMessage.Errors.REQUIRED_VALIDATION_FAILED, elementName);
        }
        LocalDate date = DateTimeUtils.parseDate(value, format);
        if (date == null) {
            throw new TradeCommonException(TradeReturnMessage.Errors.DATE_VALIDATION_FAILED, elementName);
        }

        return date;
    }
}
