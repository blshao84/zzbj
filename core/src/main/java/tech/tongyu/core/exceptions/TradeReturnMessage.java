package tech.tongyu.core.exceptions;

public interface TradeReturnMessage {
    enum Errors{
        UNKNOWN_FEATURE_ERROR(     "00000001", "不支持的公式", false),
        UNKNOWN_TRANSFORMER_ERROR( "00000002", "不支持的转换器", false),
        TRANSFORMER_MISSING_ERROR( "00000003", "查询的转换器不存在", true),
        PRODUCT_MISSING_ERROR(     "00000004", "根据产品代码未查询到产品信息", true),
        OPTION_MISSING_ERROR(      "00000005", "根据期权代码未查询到期权信息", true),
        PRODUCT_TYPE_MISSING_ERROR("00000006", "产品代码简称全称或产品代码重复", true),
        TRADE_INDEX_MISSING_ERROR( "00000007", "根据交易索引唯一编号未查询到索引", true),
        TRADE_INDEX_REPEAT_ERROR(  "00000008", "找到重名产品代码与期权代码", true),
        TRANSFORMER_NOT_FOUND_IN_SPRING_CONTAINER("000000009", "未在Spring container 中找到相应的转换器对象[%s], 请联系开发人员", true),
        SPRING_EMPTY_CONTEXT(      "000000010", "application context未注入, 请联系开发人员", false),
        UNKNOWN_PROCESSOR_ERROR(   "000000011", "不支持的生命周期", false),
        PROCESSOR_NOT_FOUND_IN_SPRING_CONTAINER("000000012", "未在Spring container 中找到相应的生命周期对象[%s], 请联系开发人员", true),
        FEATURE_NOT_FOUND_IN_SPRING_CONTAINER("000000013", "未在Spring container 中找到相应的公式对象[%s], 请联系开发人员", true),
        TRADE_PRODUCT_TYPE_NOT_FOUND("000000014", "执行的生命周期中未发现产品类型", false),
        DATA_ALREADY_EXISTS("00000015","数据库中已存在ID为[%s]的数据",true),
        DATE_VALIDATION_FAILED("000000016","日期校验失败，请重新输入(格式:yyyy-MM-dd):[%s]",false),
        MOBILEPHONE_VALIDATION_FAILED("000000017", "手机号校验失败，请输入正确的手机号", false),
        NUMERICAL_VALIDATION_FAILED("000000018","数字校验失败，必须是数字:[%s]",true),
        FOUR_DIGIT_INTEGER_VALIDATION_FAILED("000000019","数字校验失败，必须是4位整数:[%s]",true),
        MUST_BE_WITHIN_TWO_DECIMAL_PLACES_VALIDATION_FAILED("000000020","数字校验失败，必须两位小数以内:[%s]",true),
        ONLY_PDF_FORMAT_IS_SUPPORTED_VALIDATION_FAILED("000000104","文件类型校验失败，只支持PDF格式:[%s]",true),
        MUST_BE_AN_INTEGER_BETWEEN_ONE_AND_TWELVE_VALIDATION_FAILED("000000105","数字校验失败，必须是1-12之间的整数:[%s]",true),
        POSITIVE_INTEGER_VALIDATION_FAILED("000000106","数字校验失败，必须是正整数:[%s]",true),
        THE_TOTAL_LENGTH_CANNOT_EXCEED_TWENTY_VALIDATION_FAILED1("000000106","数字校验失败，保留4位小数,同时总的字符长度不能超过20,即整数位最多可为15位:[%s]",true),
        THE_TOTAL_LENGTH_CANNOT_EXCEED_TWENTY_VALIDATION_FAILED2("000000106","数字校验失败，保留2位小数,同时总的字符长度不能超过20,即整数位最多可为18位:[%s]",true),
        COUNTERPARTY_CODE_COMMON_VALIDATION_FAILED("000000109", "交易对手方组织机构代码校验失败，必须为8、9、10或18位：[%s]", true),
        COUNTERPARTY_CODE_FOR_FOREIGN_VALIDATION_FAILED("000000110", "交易对手方组织机构代码校验失败，当交易对手方类型是境外金融机构、境外非金融机构，必填00000000：[%s]", true),
        NFI_CODE_VALIDATION_FAILED("000000111", "非金融机构行业代码校验失败，交易对手方类型为非金融机构时必填：[%s]", true),
        OPTION_STRUCTURE_VALIDATION_FAILED("000000112", "期权结构校验失败，“期权结构类型”选择为其他时必填：[%s]", true),
        REQUIRED_VALIDATION_FAILED("000000113", "校验失败，字段必填：[%s]", true),
        START_DUE_DATE_VALIDATION_FAILED("000000114","日期校验失败，起始日不能大于到期日日期，到期日不能小于起始日日期：[%s]",true),
        OPTION_PREMIUM_VALIDATION_FAILED("000000115","期权费校验失败，数值处于0至1之间且最多两位小数或百分比处于0至100之间整数带%",false),
        RATIO_VALUE_VALIDATION_FAILED("000000116","比率值校验失败，请输入0到100之间的最多2位小数的数字",false),
        EXCLUSIVE_VALIDATION_FAILED("000000117", "校验失败，字段禁止填值：[%s]", true),
        MIN_VALUE_VALIDATION_FAILED("000000118", "校验失败，字段值需大于最小值：%s [%s]", true),
        MAX_VALUE_VALIDATION_FAILED("000000118", "校验失败，字段值需小于最大值：%s [%s]", true),
        REMEDIATION_VALIDATION_FAILED("000000021","首次提交时填0，补正时填1：[%s]",true),
        BETWEEN01TO04_VALIDATION_FAILED("000000022","必须是01-04之间",true),
        ;
        private String detailedErrorCode;
        private String message;
        private Boolean isTemplate;

        Errors(String detailedErrorCode, String message, Boolean isTemplate){
            this.detailedErrorCode = detailedErrorCode;
            this.message = message;
            this.isTemplate = isTemplate;
        }

        public String getDetailedErrorCode(){
            return detailedErrorCode;
        }

        public String getMessage(Object... params){
            return isTemplate
                    ? String.format(message, params)
                    : message;
        }
    }
}
