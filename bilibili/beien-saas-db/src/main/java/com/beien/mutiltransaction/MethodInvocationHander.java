package com.beien.mutiltransaction;

/**
 * @author beien
 * @date 2023/3/14 16:38
 * Copyright© 2023 beien
 */

import org.springframework.beans.factory.BeanFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 *
 */
public class MethodInvocationHander implements InvocationHandler {

    private Object target;
    private Class [] interfaceClasses;
    private ClassLoader classLoader;
    private MutilTransactional mutilTransactional;
    private BeanFactory beanFactory;
    private Map<String,MutilTransactional> methodMutilTransactionalMap;
    public MethodInvocationHander(Object targetO, Map<String,MutilTransactional> methodMutilDbTransactionalMap,BeanFactory beanFactory) throws IllegalAccessException, InstantiationException {
        Class<?> targetClass = targetO.getClass();
        Class[] interfaces = targetClass.getInterfaces();
        interfaceClasses=interfaces;
        mutilTransactional=targetClass.getDeclaredAnnotation(MutilTransactional.class);
        target= targetO;
        classLoader=targetClass.getClassLoader();
        this.beanFactory=beanFactory;
        this.methodMutilTransactionalMap=methodMutilDbTransactionalMap;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Invocation invocation=new Invocation(target,mutilTransactional,methodMutilTransactionalMap,method,args);
        MutiDSTransactionInterceptor mutiDSTransactionInterceptor = new MutiDSTransactionInterceptor(invocation,beanFactory);
        return mutiDSTransactionInterceptor.interceptor();

    }

    public Object createProxy(){
        return  Proxy.newProxyInstance(classLoader,interfaceClasses,this);
    }
}
