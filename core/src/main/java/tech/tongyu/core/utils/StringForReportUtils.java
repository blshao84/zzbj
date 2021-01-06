package tech.tongyu.core.utils;

import tech.tongyu.core.enums.OperationEnum;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 字符串辅助
 **/
public class StringForReportUtils {

    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyyMMdd");

    public static String generateZipName(String senderCode, String receiverCode, LocalDate operationDate, Integer version) {
        StringBuffer start = new StringBuffer("OTC_");
        start.append(senderCode + "_");
        start.append(receiverCode + "_");
        String operationDateString = operationDate.format(fmt);
        start.append(operationDateString + "_");
        String versionString = String.format("%04d", version);
        start.append(versionString + ".zip");
        return start.toString();
    }

    public static String generateXmlName(String senderCode, String receiverCode, LocalDate operationDate,
                                         Integer version, String code, OperationEnum operation) {
        StringBuffer start = new StringBuffer("OTC_");
        start.append(senderCode + "_");
        start.append(receiverCode + "_");
        String operationDateString = operationDate.format(fmt);
        start.append(operationDateString + "_");
        String versionString = String.format("%04d", version);
        start.append(versionString + "_");
        start.append(code + "_");
        start.append(operation.code() + ".xml");
        return start.toString();
    }

    public static LinkedHashMap<String, String> buildRequestHeader(String senderCode, String receiverCode, LocalDate operationDate,
                                                                   Integer fileNumber, String code, OperationEnum operation) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fileNumberString = String.format("%04d", fileNumber);
        String operationDateString = operationDate.format(format);
        map.put("Version", "001");
        map.put("SenderCode", senderCode);
        map.put("ReceiverCode", receiverCode);
        map.put("SendDate", operationDateString);
        map.put("FileNumber", fileNumberString);
        map.put("BusiDataType", code);
        map.put("OperationType", operation.code());
        return map;
    }

    public static String buildExecID(String senderCode, String receiverCode, LocalDate operationDate, Integer version, Integer sort) {
        StringBuffer start = new StringBuffer();
        start.append(senderCode);
        start.append(receiverCode);
        String operationDateString = operationDate.format(fmt);
        start.append(operationDateString);
        start.append(String.format("%04d", version));
        start.append(String.format("%04d", sort));
        return start.toString();
    }
}
