package com.hjy.util;

/**
 * 用户自定义业务逻辑处理层异常类
 * @author hjy
 * @create 2017/11/15
 **/
public class ServiceException extends Exception {

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}