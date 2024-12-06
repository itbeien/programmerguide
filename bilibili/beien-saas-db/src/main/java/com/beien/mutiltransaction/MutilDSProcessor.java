package com.beien.mutiltransaction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author beien
 * @date 2023/3/14 16:26
 * Copyright© 2023 beien
 */
@Slf4j
@Component
public class MutilDSProcessor implements BeanPostProcessor, BeanFactoryAware {

    private BeanFactory beanFactory;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> aClass = bean.getClass();
        if(aClass.isAnnotationPresent(MutilTransactional.class)){
            log.info("{} 被MutilTransactional注解修饰  现在为它生成代理对象-------------",beanName);
            try {
                return  new MethodInvocationHander(bean,null,beanFactory).createProxy();
            } catch (Exception e) {
                e.printStackTrace();
                throw  new RuntimeException(bean+"：创建代理失败！！");
            }

        }else{
            Method[] declaredMethods = aClass.getDeclaredMethods();
            Map<String,MutilTransactional> methodMutilTransactionalMap=new HashMap<>();
            for(Method m:declaredMethods){
                if(m.isAnnotationPresent(MutilTransactional.class)) {
                    methodMutilTransactionalMap.put(MutiTransactionUtil.keyGenarate(m),m.getAnnotation(MutilTransactional.class));
                }
            }
            if(methodMutilTransactionalMap.keySet().size()>0){
                log.info("{} 类 有方法： 被MutilDbTransactional注解修饰  现在为它生成代理对象-------------",beanName);
                try {
                    return   new MethodInvocationHander(bean,methodMutilTransactionalMap,beanFactory).createProxy();
                } catch (Exception e) {
                    e.printStackTrace();
                    throw  new RuntimeException("创建代理对象失败！");
                }
            }


        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return  bean;
    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory=beanFactory;
    }
}
