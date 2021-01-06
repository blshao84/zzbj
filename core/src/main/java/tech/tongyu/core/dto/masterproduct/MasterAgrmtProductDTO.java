package tech.tongyu.core.dto.masterproduct;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Strings;
import tech.tongyu.core.dto.common.RequestCommon;
import tech.tongyu.core.dto.contract.ContractNumberProcessDTO;
import tech.tongyu.core.enums.OperationEnum;
import tech.tongyu.core.utils.common.JsonUtils;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 主协议关联产品列表
 */
@JsonPropertyOrder({"ExceID", "BizID", "MasterAgrmtNo", "ProductNo", "ProductName"
        , "ManagerName", "InvestmentManagerContactNumber", "TrusteeAgency", "TheDateTable"
        , "SuchProducts"})
public class MasterAgrmtProductDTO extends RequestCommon {

    /**
     * 主协议编号(双方约定)
     */
    private String MasterAgrmtNo;

    /**
     * 代签产品编号
     */
    private String ProductNo;

    /**
     * 产品名称
     */
    private String ProductName;

    /**
     * 产品投资经理姓名
     */
    private String ManagerName;

    /**
     * 投资经理联系电话
     */
    private String InvestmentManagerContactNumber;

    /**
     * 托管机构(如有)
     */
    private String TrusteeAgency;

    /**
     * 入表日期
     */
    private String TheDateTable;

    /**
     * 代签产品附件
     */
    private String SuchProducts;

    public static MasterAgrmtProductDTO fromJson(JsonNode json) {
        return fromJson(json, Optional.empty());
    }

    public static MasterAgrmtProductDTO fromJson(JsonNode json, Optional<OperationEnum> op) {
        MasterAgrmtProductDTO dto = JsonUtils.mapper.convertValue(json, MasterAgrmtProductDTO.class);
        op.ifPresent(o -> {
            if (o.equals(OperationEnum.UPDATE) || o.equals(OperationEnum.DELETE)) {
                dto.setProductNo(dto.getBizID());
                dto.setBizID(null);
            }
        });
        removeNullableFields(dto);
        return dto;
    }

    private static void removeNullableFields(MasterAgrmtProductDTO dto) {
        if (Strings.isNullOrEmpty(dto.getTrusteeAgency())) {
            dto.setTrusteeAgency(null);
        }
    }

    public MasterAgrmtProductDTO() {
    }

    public MasterAgrmtProductDTO(String masterAgrmtNo, String productNo, String productName,
                                 String managerName, String investmentManagerContactNumber,
                                 String trusteeAgency, String theDateTable, String suchProducts) {
        MasterAgrmtNo = masterAgrmtNo;
        ProductNo = productNo;
        ProductName = productName;
        ManagerName = managerName;
        InvestmentManagerContactNumber = investmentManagerContactNumber;
        TrusteeAgency = trusteeAgency;
        TheDateTable = theDateTable;
        SuchProducts = suchProducts;
    }

    public LinkedHashMap<String, Object> toLinkedHashMap() {
        return JsonUtils.fromJsonToLinkedHashMap(JsonUtils.toJson(this));
    }

    @JsonProperty("MasterAgrmtNo")
    public String getMasterAgrmtNo() {
        return MasterAgrmtNo;
    }

    public void setMasterAgrmtNo(String masterAgrmtNo) {
        MasterAgrmtNo = masterAgrmtNo;
    }

    @JsonProperty("ProductNo")
    public String getProductNo() {
        return ProductNo;
    }

    public void setProductNo(String productNo) {
        ProductNo = productNo;
    }

    @JsonProperty("ProductName")
    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    @JsonProperty("ManagerName")
    public String getManagerName() {
        return ManagerName;
    }

    public void setManagerName(String managerName) {
        ManagerName = managerName;
    }

    @JsonProperty("InvestmentManagerContactNumber")
    public String getInvestmentManagerContactNumber() {
        return InvestmentManagerContactNumber;
    }

    public void setInvestmentManagerContactNumber(String investmentManagerContactNumber) {
        InvestmentManagerContactNumber = investmentManagerContactNumber;
    }

    @JsonProperty("TrusteeAgency")
    public String getTrusteeAgency() {
        return TrusteeAgency;
    }

    public void setTrusteeAgency(String trusteeAgency) {
        TrusteeAgency = trusteeAgency;
    }

    @JsonProperty("TheDateTable")
    public String getTheDateTable() {
        return TheDateTable;
    }

    public void setTheDateTable(String theDateTable) {
        TheDateTable = theDateTable;
    }

    @JsonProperty("SuchProducts")
    public String getSuchProducts() {
        return SuchProducts;
    }

    public void setSuchProducts(String suchProducts) {
        SuchProducts = suchProducts;
    }
}
