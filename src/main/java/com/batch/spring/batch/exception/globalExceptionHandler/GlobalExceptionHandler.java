package com.batch.spring.batch.exception.globalExceptionHandler;

import com.batch.spring.batch.exception.ServiceException;
import com.batch.spring.batch.utils.JsonResult;
import com.batch.spring.batch.utils.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 俊翔，學習加油，今天是 2022/11/11 下午 02:38
 * 時間: 14 38
 * 好好努力~桿八爹
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler//針對處裡異常方法的註解
    //決定處裡異常方法所該針對得異常是哪個是取決於其參數來決定
    public JsonResult<Void> HandleServiceException(ServiceException e){
        return JsonResult.fail(e);
    }

    @ExceptionHandler
    public JsonResult<Void> OverAllException(Throwable e){
        e.printStackTrace();
        return JsonResult.fail(ServiceCode.ERR_BAD_REQUEST,"服務錯誤");
    }

}
