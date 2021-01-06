package tech.tongyu.model.dao.config;

import tech.tongyu.core.enums.DataTypeEnum;
import tech.tongyu.model.dao.common.BaseEntity;

import javax.persistence.*;

import static tech.tongyu.core.constant.ServiceConstant.BASE_ELEMENT;
import static tech.tongyu.core.constant.ServiceConstant.COMMERCE_MODEL;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 请求报头格式
 **/
@Entity
@Table(schema = COMMERCE_MODEL, name = BASE_ELEMENT)
public class BaseElementDbo extends BaseEntity {
    /**
     * 协议ID
     * StructureConfigDbo -> code
     */
    @Column
    private String code;
    /**
     * 字段名称(真实xml使用的字段名)
     */
    @Column
    private String elementName;
    /**
     * 字段说明(中文解释,展示用)
     */
    @Column
    private String elementDescription;
    /**
     * 数据类型(sql拼装使用)
     */
    @Column
    @Enumerated(value = EnumType.STRING)
    private DataTypeEnum dataType;
    /**
     * 小数点精度
     */
    @Column
    private Integer rounding;
    /**
     * 是否必填
     */
    @Column
    private Boolean required;
    /**
     * 默认值
     */
    @Column
    private String defaultValue;
    /**
     * 源层命名
     */
    @Column
    private String odsName;
    /**
     * 源层数据库
     */
    @Column
    private String odsSchema;
    /**
     * 源层表
     */
    @Column
    private String odsTableName;
    /**
     * 目标层命名
     */
    @Column
    private String sourceName;
    /**
     * 过滤Class
     */
    @Column
    private String filterClass;

    @Column
    private Integer sort;

    @Column
    private Boolean useAssociate;

    @Column
    private Boolean status;

    @Column
    private String parentId;

    @Column
    private String valueRemark;

    @Column
    private String valueVerification;

    @Column
    private String excelRange;

    @Column
    private String excelSheet;

    @Column
    private Boolean isList;

    @Column
    private Boolean ListFlag;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getElementDescription() {
        return elementDescription;
    }

    public void setElementDescription(String elementDescription) {
        this.elementDescription = elementDescription;
    }

    public DataTypeEnum getDataType() {
        return dataType;
    }

    public void setDataType(DataTypeEnum dataType) {
        this.dataType = dataType;
    }

    public Integer getRounding() {
        return rounding;
    }

    public void setRounding(Integer rounding) {
        this.rounding = rounding;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getOdsName() {
        return odsName;
    }

    public void setOdsName(String odsName) {
        this.odsName = odsName;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getFilterClass() {
        return filterClass;
    }

    public void setFilterClass(String filterClass) {
        this.filterClass = filterClass;
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getUseAssociate() {
        return useAssociate;
    }

    public void setUseAssociate(Boolean useAssociate) {
        this.useAssociate = useAssociate;
    }

    public Boolean getListFlag() {
        return ListFlag;
    }

    public void setListFlag(Boolean listFlag) {
        ListFlag = listFlag;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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

    public String getExcelSheet() {
        return excelSheet;
    }

    public void setExcelSheet(String excelSheet) {
        this.excelSheet = excelSheet;
    }

    public Boolean getList() {
        return isList;
    }

    public void setList(Boolean list) {
        isList = list;
    }
}
