package tech.tongyu.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import tech.tongyu.model.dao.config.AttachmentConfigDbo;

import java.util.List;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 附件
 **/
public interface AttachmentConfigRepo extends JpaRepository<AttachmentConfigDbo, String> {

    /**
     * 根据协议编码查询未发送附件
     * @param code 协议编码
     * @return 附件列表
     */
    @Query("from AttachmentConfigDbo a where a.attachmentId = ?1 and a.status = false ")
    List<AttachmentConfigDbo> listAttachmentByCode(String code);

    /**
     * 根据业务编码删除数据
     */
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    int deleteAllByAttachmentIdAndStatus(String code, Boolean status);
}
