package tech.tongyu.core.dto.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.JsonNode;
import tech.tongyu.core.dto.common.RequestCommon;
import tech.tongyu.core.enums.OperationEnum;
import tech.tongyu.core.utils.common.JsonUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 双方约定编号数据处理
 */
@JsonPropertyOrder({"ExceID", "BizID", "MasterAgrmtTuple", "SupAgrmtTuple",
        "OptionConfirmationTuple", "SwapConfirmationTuple"})
public class ContractNumberProcessDTO extends RequestCommon {

    private List<MasterAgrmtTupleDTO> MasterAgrmtTuple;
    private List<SupAgrmtTupleDTO> SupAgrmtTuple;
    private List<OptionConfirmationTupleDTO> OptionConfirmationTuple;
    private List<SwapConfirmationTupleDTO> SwapConfirmationTuple;

    public ContractNumberProcessDTO() {
    }

    public static ContractNumberProcessDTO fromJson(JsonNode json) {
        return fromJson(json, Optional.empty());
    }

    public static ContractNumberProcessDTO fromJson(JsonNode json, Optional<OperationEnum> op) {
        ContractNumberProcessDTO dto = JsonUtils.mapper.convertValue(json, ContractNumberProcessDTO.class);
        return dto;
    }

    public ContractNumberProcessDTO(List<MasterAgrmtTupleDTO> masterAgrmtTuple, List<SupAgrmtTupleDTO> supAgrmtTuple, List<OptionConfirmationTupleDTO> optionConfirmationTuple, List<SwapConfirmationTupleDTO> swapConfirmationTuple) {
        MasterAgrmtTuple = masterAgrmtTuple;
        SupAgrmtTuple = supAgrmtTuple;
        OptionConfirmationTuple = optionConfirmationTuple;
        SwapConfirmationTuple = swapConfirmationTuple;
    }

    public LinkedHashMap<String, Object> toLinkedHashMap() {
        return JsonUtils.fromJsonToLinkedHashMap(JsonUtils.toJson(this));
    }

    @JsonProperty("MasterAgrmtTuple")
    public List<MasterAgrmtTupleDTO> getMasterAgrmtTuple() {
        return MasterAgrmtTuple;
    }

    public void setMasterAgrmtTuple(List<MasterAgrmtTupleDTO> masterAgrmtTuple) {
        MasterAgrmtTuple = masterAgrmtTuple;
    }

    @JsonProperty("SupAgrmtTuple")
    public List<SupAgrmtTupleDTO> getSupAgrmtTuple() {
        return SupAgrmtTuple;
    }

    public void setSupAgrmtTuple(List<SupAgrmtTupleDTO> supAgrmtTuple) {
        SupAgrmtTuple = supAgrmtTuple;
    }

    @JsonProperty("OptionConfirmationTuple")
    public List<OptionConfirmationTupleDTO> getOptionConfirmationTuple() {
        return OptionConfirmationTuple;
    }

    public void setOptionConfirmationTuple(List<OptionConfirmationTupleDTO> optionConfirmationTuple) {
        OptionConfirmationTuple = optionConfirmationTuple;
    }

    @JsonProperty("SwapConfirmationTuple")
    public List<SwapConfirmationTupleDTO> getSwapConfirmationTuple() {
        return SwapConfirmationTuple;
    }

    public void setSwapConfirmationTuple(List<SwapConfirmationTupleDTO> swapConfirmationTuple) {
        SwapConfirmationTuple = swapConfirmationTuple;
    }
}
