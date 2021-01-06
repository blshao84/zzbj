package tech.tongyu.transform.check;

import java.util.Map;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 校验检测基础
 **/
public interface CheckAction {

    /**
     * 获取校验名称
     *
     * @return 校验名称
     */
    String getCheckName();

    /**
     * 校验方法
     *
     * @param data        传入参数
     * @param elementName 校验元素
     * @return 校验完成数据
     */
    Object execute(Map<String, Object> data, String elementName);

    /**
     * 返回校验参数类型
     *
     * @return 具体校验数据类型
     */
    Class<?> getClassType();

}
