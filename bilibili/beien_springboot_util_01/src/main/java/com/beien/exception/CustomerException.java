package com.beien.exception;

public class CustomerException extends RuntimeException{
    // 空参构造方法
    public CustomerException() {
    }
    //带异常信息的构造方法
    /*
    查看源码发现，所有的异常类都会有一个带异常信息的构造方法，
    方法内部会调用父类带异常信息的构造方法，让父类来处理这个异常信息
     */
    public CustomerException(String message){
        super(message);
    }
}
