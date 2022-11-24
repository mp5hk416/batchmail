package com.batch.spring.batch.utils;

import com.batch.spring.batch.exception.ServiceException;
import lombok.Data;

/**
 * 俊翔，學習加油，今天是 2022/11/11 下午 01:55
 * 時間: 13 55
 * 好好努力~桿八爹
 */
@Data
public class JsonResult<T> {

    /**
     * 業務狀態碼
     */
    private Integer code;
    /**
     * 狀態信息
     */
    private String message;

    /**
     * 處裡成功，需要響應給客戶端數據
     */
    private T data;

    //    public JsonResult(Integer code,String message){
//        this.code = code;
//        this.message = message;
//    }
    //響應成功，不需要響應數據
    public static JsonResult<Void> ok() {
//        JsonResult result = new JsonResult();
//        result.code = ServiceCode.OK;
//        result.message = ServiceStateSaying.OKMESSAGE;
//        return result;
        //調用下面重寫的方法裡面塞空物件返回
        return ok(null);
    }
    //重寫方法，包含數據
    public static <T>JsonResult<T> ok(T data) {
        JsonResult<T> result = new JsonResult();
        result.code = ServiceCode.OK;
        result.data = data;
        return result;
    }

    public static JsonResult build(Integer code, String message) {
        JsonResult<Void> result = new JsonResult();
        result.code = code;
        result.message = message;
        return result;
    }

    //響應失敗
    public static JsonResult<Void> fail(Integer code, String message) {
        JsonResult<Void> result = new JsonResult();
        result.code = code;
        result.message = message;
        return result;
    }
    public static JsonResult<Void> fail(ServiceException e) {
        return JsonResult.fail(e.getServiceCode(),e.getMessage());
    }

}
