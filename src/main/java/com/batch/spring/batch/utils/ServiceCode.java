package com.batch.spring.batch.utils;

/**
 * Hi User
 * 今天是美好的一天
 * 日期:下午 09:43 2022/7/27 2022
 * 好好加油
 */
//存儲狀態碼
public class ServiceCode {
    public static final int OK =20000;//避免跟http重號
    //錯誤，衝突，通常是ˋ因為出現重複數據
    public static final int ERR_CONFLICT =40900;
    //錯誤，數據格是錯誤
    public static final int ERR_BAD_REQUEST =40000;
    //插入失敗
    public static final int ERR_INSERT = 50000;
    //刪除失敗
    public static final int ERR_DELETE = 50001;
    //更新失敗
    public static final int ERR_UPDATE = 50002;
    //數據不存在
    public static final int DATA_NOT_EXISTS = 40400;
    //未知錯誤
    public static final int ERR_UNKNOWN = 59999;

}
