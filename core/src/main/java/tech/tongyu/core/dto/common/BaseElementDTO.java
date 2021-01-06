package tech.tongyu.core.dto.common;

import tech.tongyu.core.enums.DataTypeEnum;

import java.util.Date;

public class BaseElementDTO {

    private String id;
    private Date createTime;
    private Date updateTime;
    private String code;
    private DataTypeEnum dataType;
    private String defaultValue;
    private String elementDescription;
    private String elementName;
    private String filterClass;
    private String odsName;
    private String odsSchema;
    private String odsTableName;
    private String parentId;
    private Boolean required;
    private Integer rounding;
    private String sourceName;
    private Integer sort;
    private Boolean status;
    private Boolean useAssociate;
    private String valueRemark;
    private String valueVerification;
    private String excelRange;
    private Boolean isList;
    private Boolean ListFlag;
    private String excelSheet;

    public BaseElementDTO() {
    }

    public BaseElementDTO(String id, Date createTime, Date updateTime, String code, DataTypeEnum dataType, String defaultValue, String elementDescription, String elementName, String filterClass, String odsName, String odsSchema, String odsTableName, String parentId, Boolean required, Integer rounding, String sourceName, Integer sort, Boolean status, Boolean useAssociate, String valueRemark, String valueVerification, String excelRange, Boolean isList, Boolean listFlag, String excelSheet) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.code = code;
        this.dataType = dataType;
        this.defaultValue = defaultValue;
        this.elementDescription = elementDescription;
        this.elementName = elementName;
        this.filterClass = filterClass;
        this.odsName = odsName;
        this.odsSchema = odsSchema;
        this.odsTableName = odsTableName;
        this.parentId = parentId;
        this.required = required;
        this.rounding = rounding;
        this.sourceName = sourceName;
        this.sort = sort;
        this.status = status;
        this.useAssociate = useAssociate;
        this.valueRemark = valueRemark;
        this.valueVerification = valueVerification;
        this.excelRange = excelRange;
        this.isList = isList;
        ListFlag = listFlag;
        this.excelSheet = excelSheet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataTypeEnum getDataType() {
        return dataType;
    }

    public void setDataType(DataTypeEnum dataType) {
        this.dataType = dataType;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getElementDescription() {
        return elementDescription;
    }

    public void setElementDescription(String elementDescription) {
        this.elementDescription = elementDescription;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getFilterClass() {
        return filterClass;
    }

    public void setFilterClass(String filterClass) {
        this.filterClass = filterClass;
    }

    public String getOdsName() {
        return odsName;
    }

    public void setOdsName(String odsName) {
        this.odsName = odsName;
    }

    public String getOdsSchema() {
        return odsSchema;
    }

    public void setOdsSchema(String odsSchema) {
        this.odsSchema = odsSchema;
    }

    public String getOdsTableName() {
        return odsTableName;
    }

    public void setOdsTableName(String odsTableName) {
        this.odsTableName = odsTableName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public Integer getRounding() {
        return rounding;
    }

    public void setRounding(Integer rounding) {
        this.rounding = rounding;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getUseAssociate() {
        return useAssociate;
    }

    public void setUseAssociate(Boolean useAssociate) {
        this.useAssociate = useAssociate;
    }

    public String getValueRemark() {
        return valueRemark;
    }

    public void setValueRemark(String valueRemark) {
        this.valueRemark = valueRemark;
    }

    public String getValueVerification() {
        return valueVerification;
    }

    public void setValueVerification(String valueVerification) {
        this.valueVerification = valueVerification;
    }

    public String getExcelRange() {
        return excelRange;
    }

    public void setExcelRange(String excelRange) {
        this.excelRange = excelRange;
    }

    public Boolean getList() {
        return isList;
    }

    public void setList(Boolean list) {
        isList = list;
    }

    public Boolean getListFlag() {
        return ListFlag;
    }

    public void setListFlag(Boolean listFlag) {
        ListFlag = listFlag;
    }

    public String getExcelSheet() {
        return excelSheet;
    }

    public void setExcelSheet(String excelSheet) {
        this.excelSheet = excelSheet;
    }
}
