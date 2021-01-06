package tech.tongyu.transform.check.impl;

import org.apache.commons.lang3.StringUtils;
import tech.tongyu.core.exceptions.TradeCommonException;
import tech.tongyu.core.exceptions.TradeReturnMessage;
import tech.tongyu.core.utils.common.DateTimeUtils;
import tech.tongyu.transform.check.CheckAction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

import static tech.tongyu.core.exceptions.TradeReturnMessage.Errors.DATE_VALIDATION_FAILED;

/**
 * 起始日期校验
 * <p>
 * 校验规则：
 * 1. 起始日期和到期日期必填；
 * 2. 符合一定格式
 * 3. 起始日期不能大于到期日
 */
public abstract class AbstractStartDateCheck implements CheckAction {

    @Override
    public String getCheckName() {
        return "起始日期校验";
    }

    @Override
    public Object execute(Map<String, Object> data, String elementName) {
        String startDateValue = Objects.toString(data.get(elementName), "");
        String dateFormat = dateParseFormat();
        LocalDate startDate = parseDate(startDateValue, dateFormat, elementName);
        LocalDate dueDate = getDueDate(data, elementName);

        if (startDate.isAfter(dueDate)) {
            throw new TradeCommonException(TradeReturnMessage.Errors.START_DUE_DATE_VALIDATION_FAILED, elementName);
        }

        return DateTimeUtils.formatDate(startDate, dateOutFormat());
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
     * Due date 字段名
     *
     * @return
     */
    public abstract String dueDateName();

    /**
     * 解析获取到期日期
     *
     * @param data        数据集
     * @param elementName 当前检查字段
     * @return
     */
    public LocalDate getDueDate(Map<String, Object> data, String elementName) {
        String dueDateName = dueDateName();
        String value = Objects.toString(data.get(dueDateName), "");
        return parseDate(value, dateParseFormat(), dueDateName);
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
