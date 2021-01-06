package tech.tongyu.core.service.base;

import tech.tongyu.core.dto.masterproduct.MasterAgrmtProductDTO;
import tech.tongyu.core.enums.OperationEnum;

import java.util.List;
import java.util.Map;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 主协议关联产品列表
 */
public interface MasterAgreementProductService extends AgreementService {

    /**
     * 查询主协议关联产品列表data层数据
     * 注意:
     *   1.获取的是当前最新的data层数据
     * @return data层数据
     */
    List<MasterAgrmtProductDTO> listMasterAgreementProduct();

}
