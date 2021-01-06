package tech.tongyu.core.service.base;

import tech.tongyu.core.dto.common.ResponseCommon;
import tech.tongyu.core.dto.common.ResponseData;
import tech.tongyu.core.enums.InterfaceInfoEnum;
import tech.tongyu.core.enums.OperationEnum;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 中心协议扫描
 **/
public interface AgreementService extends Serializable {

    String bizId_field = "BizID";

    /**
     * 获取service类型
     * @return 接口类型
     */
    String getServiceType();

    /**
     * 执行数据清洗与转换
     * @return 是否清洗与转换完成
     */
    Boolean executeTransTask();

    /**
     * 执行xml生成与zip压缩
     * @param operation 操作
     * @return 临时文件路径
     */
    String executeGenerateTask(OperationEnum operation);

    /**
     * 查询双方约定编号数据处理data层数据
     * 注意:
     *   1.获取的是当前最新的data层数据
     * @return data层数据
     */
    List<Map<String, Object>> listReportMap();

    /**
     * 保存双方约定编号数据处理发送状态
     * @param data 保存数据
     * @return 是否完成保存
     */
    Boolean saveReport(List<Map<String, Object>> data);

    /**
     * 更新双方约定编号数据处理
     * @param data 更新双方约定编号数据处理
     * @param bizId 业务编码
     * @return 是否完成更新
     */
    Boolean updateReport(String bizId, Map<String, Object> data);

    /**
     * 删除双方约定编号数据处理
     * @param bizId 双方约定编号数据处理ID
     * @return 是否完成删除
     */
    Boolean deleteReport(String bizId);

    /**
     * 归档数据
     * @param response 归档数据
     * @return 归档完成
     */
    ResponseData archiveData(ResponseCommon response);

}
