package tech.tongyu.core.dto.quarter;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 定期报告-季报
 */
public class DerivativesQuarterlyReportAnnexDTO {

    private String DerivativesQuarterlyReportAnnex;

    public DerivativesQuarterlyReportAnnexDTO() {
    }

    public DerivativesQuarterlyReportAnnexDTO(String derivativesQuarterlyReportAnnex) {
        DerivativesQuarterlyReportAnnex = derivativesQuarterlyReportAnnex;
    }

    @JsonProperty("DerivativesQuarterlyReportAnnex")
    public String getDerivativesQuarterlyReportAnnex() {
        return DerivativesQuarterlyReportAnnex;
    }

    public void setDerivativesQuarterlyReportAnnex(String derivativesQuarterlyReportAnnex) {
        DerivativesQuarterlyReportAnnex = derivativesQuarterlyReportAnnex;
    }
}
