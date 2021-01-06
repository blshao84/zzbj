package tech.tongyu.transform.manager;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import tech.tongyu.transform.check.CheckAction;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 校验类获取Manager
 **/
@Component
public class CheckActionManager implements ApplicationContextAware {

    private static Map<String, CheckAction> map = new ConcurrentHashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        map = applicationContext.getBeansOfType(CheckAction.class);
    }

    public Map<String, CheckAction> getCheckMap(){
        return map;
    }

    public CheckAction getCheckAction(String checkActionName) {
        return map.get(checkActionName);
    }

}
