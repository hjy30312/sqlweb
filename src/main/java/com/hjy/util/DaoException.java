package com.hjy.util;

/**
 * 用户自定义数据访问层异常类
 * @author hjy
 * @create 2017/11/15
 **/
public class DaoException extends RuntimeException {

    public DaoException() {
        super();
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }
}