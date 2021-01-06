package tech.tongyu.transform.manager;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import tech.tongyu.core.exceptions.CustomCommonException;
import tech.tongyu.core.exceptions.CustomErrorMessage;

import java.util.Objects;

@Component
public class SpringBeanGetter implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private <T> T getTargetObject(String className, CustomErrorMessage.Errors classNotFoundError, CustomErrorMessage.Errors noSuchBeanDefError){
        try{
            Class<? extends T> targetClass = (Class<? extends T>) Class.forName(className);
            if(Objects.isNull(applicationContext)) {
                throw new CustomCommonException(CustomErrorMessage.Errors.SPRING_EMPTY_CONTEXT);
            }

            return applicationContext.getBean(targetClass);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
            throw new CustomCommonException(classNotFoundError, className);
        } catch (NoSuchBeanDefinitionException e){
            e.printStackTrace();
            throw new CustomCommonException(noSuchBeanDefError, className);
        }
    }

    public Class getBeanClass(String className) {
        return getTargetObject(className
                , CustomErrorMessage.Errors.UNKNOWN_ERROR
                , CustomErrorMessage.Errors.NOT_FOUND_IN_SPRING_CONTAINER
        );
    }

}
