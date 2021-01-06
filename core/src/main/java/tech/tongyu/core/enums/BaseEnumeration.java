package tech.tongyu.core.enums;

import java.io.Serializable;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 公共枚举类接口
 * @date 22:39 2020/8/3 0003
 **/
public interface BaseEnumeration extends Serializable {

    /**
     * 英文描述
     * @return 英文描述
     */
    String code();

    /**
     * 描述
     * @return 描述
     */
    String description();
}
