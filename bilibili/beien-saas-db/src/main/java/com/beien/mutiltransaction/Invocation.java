package com.beien.mutiltransaction;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author beien
 * @date 2023/3/14 16:32
 * Copyright© 2023 beien
 */
public class Invocation {
    private Method method;
    private Object[] args;
    private  Object target;
    private MutilTransactional mutilTransactional;
    private Map<String,MutilTransactional> methodMutilTransactionalMap;
    public Invocation(Object t, MutilTransactional mutilDbTransactional,Map<String,MutilTransactional> methodMutilDbTransactionalMap, Method method, Object[] args) {
        target=t;
        this.method = method;
        this.args = args;
        this.mutilTransactional=mutilDbTransactional;
        this.methodMutilTransactionalMap=methodMutilDbTransactionalMap;
    }

    public MutilTransactional getMutilTransactional() {
        return mutilTransactional;
    }

    public Object execute() throws Throwable {
        return  method.invoke(target,args);
    }

    public Method getMethod() {
        return method;
    }

    public Object[] getArgs() {
        return args;
    }

    public Object getTarget() {
        return target;
    }

    public Map<String, MutilTransactional> getMethodMutilTransactionalMap() {
        return methodMutilTransactionalMap;
    }
}
