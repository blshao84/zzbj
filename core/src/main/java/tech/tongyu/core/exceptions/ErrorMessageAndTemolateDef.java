package tech.tongyu.core.exceptions;

public interface ErrorMessageAndTemolateDef {

    enum Errors{
        UNKNOWN_ERROR(                                    "00000001", "未知错误", false),
        FILE_UPLOAD_ERROR(                                "00000002", "上传失败,请检测文件大小后重新上传(最大文件限制为100MB)", false),
        FILE_NOT_FOUND(                                   "00000003", "根据文件路径未找到文件信息", false),
        FILE_DOWNLOAD_ERROR(                              "00000004", "文件下载失败,请联系管理员或重新下载", false),
        TEMPLATE_NOT_FOUND(                               "00000005", "文件模板未找到,上传模板或联系管理员", false),
        LOG_NOT_FOUND(                                    "00000006", "文件日志未找到,是否已删除或不存在", false),
        INITIALIZE_FREEMARKER_TEMPLATE_ERROR(             "00000007", "无法初始化Freemarker模板,请联系管理员", false),
        TEMPLATE_ERROR(                                   "00000008", "文档模板出现问题,请重新上传模板或联系管理员", false),
        WRITER_ERROR(                                     "00000009", "写入数据流失败,请确认上传模板正确或联系管理员", false),
        TEMPLATE_DIR_NOT_FOUND(                           "00000010", "未找到该类型的模板组,请联系管理员", false),
        GROUP_NOT_FOUND(                                  "00000011", "根据字典组ID未找到字典组,请确认字典组是否存在", false),
        ENTRY_NOT_FOUND(                                  "00000012", "根据字典ID未找到字典,请确认字典组是否存在", false),
        TEMPLATE_DIR_REPEAT_ERROR(                        "00000013", "已存在相同名称的模板组", false),
        TEMPLATE_ACTIVE_ERROR(                            "00000014", "当前模板为正在使用的模板,请使用其他模板后再进行删除", false),
        TEMPLATE_CREATE_AUTH_ERROR(                       "00000015", "您没有权限创建模板，请联系管理员", false),
        TEMPLATE_DELETE_AUTH_ERROR(                       "00000016", "您没有权限删除模板，请联系管理员", false),
        DOWNLOAD_AUTH_ERROR(                              "00000017", "您没有权限下载文档，请联系管理员", false),
        UPLOAD_AUTH_ERROR(                                "00000018", "您没有权限上传文档，请联系管理员", false),
        DIR_GROUP_NOT_FOUND(                              "00000019", "字典组未找到,请重新选择或联系管理员", false),
        DIR_GROUP_REPEAT_ERROR(                           "00000020", "已存在相同名称的字典组,请重新创建或联系管理员", false),
        GROUP_REPEAT_ERROR(                               "00000021", "已存在相同名称的字典,请重新创建或联系管理员", false),
        INPUT_ERROR(                                      "00000022", "请求参数缺失,请重新请求", false),
        TEMPLATE_MISSING_ERROR(                           "00000023", "根据模板ID未找到模板,请确认模板是否存在", false),
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
