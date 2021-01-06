package tech.tongyu.core.exceptions;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 错误信息
 **/
public interface CustomErrorMessage {

    enum Errors{
        UNKNOWN_ERROR(                "00000001", "未知错误", false),
        NOT_FOUND_DATA(               "00000002","从数据库中未找到数据", false),
        SPRING_EMPTY_CONTEXT(         "00000003", "application context未注入, 请联系开发人员", false),
        NOT_FOUND_IN_SPRING_CONTAINER("00000004", "未在Spring container 中找到相应的对象[%s], 请联系开发人员", true),
        DATA_REPEAT(                  "00000005","已经存在相同业务编码的数据",false),
        PARAM_TYPE_ERROR(             "00000006", "参数类型转换错误:[%s]", true),
        SHELL_EXECUTE_ERROR(          "00000007","shell脚本执行错误:[%s]", true),
        FILE_NOT_FOUND(               "00000008", "根据文件路径未找到文件信息", false),
        FILE_DOWNLOAD_ERROR(          "00000009", "文件下载失败,请联系管理员或重新下载", false),
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
