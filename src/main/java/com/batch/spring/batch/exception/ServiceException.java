package com.batch.spring.batch.exception;

/**
 * Hi User
 * 今天是美好的一天
 * 日期:下午 08:00 2022/7/27 2022
 * 好好加油
 */
//自定義一個服務器服務異常
    //檢查行異常 繼承Exception 運行時異常 繼承RunTimeException
public class ServiceException extends RuntimeException{

    private Integer serviceCode;

    public ServiceException(Integer serviceCode , String message) {
        super(message);
        this.serviceCode = serviceCode;
    }

    public Integer getServiceCode() {
        return serviceCode;
    }
    //    public ServiceException(String message, Throwable cause) {
//        super(message, cause);
//    }
//
//    public ServiceException(Throwable cause) {
//        super(cause);
//    }
//
//    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
//        super(message, cause, enableSuppression, writableStackTrace);
//    }
}
