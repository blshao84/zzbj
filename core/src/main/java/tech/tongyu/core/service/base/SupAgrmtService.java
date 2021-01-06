package tech.tongyu.core.service.base;

import tech.tongyu.core.dto.sup.SupAgrmtDTO;
import tech.tongyu.core.enums.OperationEnum;

import java.util.List;
import java.util.Map;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 补充协议
 */
public interface SupAgrmtService extends AgreementService {

    /**
     * 查询补充协议data层数据
     * 注意:
     * 1.获取的是当前最新的data层数据
     *
     * @return data层数据
     */
    List<SupAgrmtDTO> listSupAgrmt();

}