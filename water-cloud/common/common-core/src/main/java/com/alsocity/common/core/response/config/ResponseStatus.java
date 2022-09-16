package com.alsocity.common.core.response.config;

/**
 * @author : 小凡
 * @date : create in 2021/7/22 15:14
 * description :
 **/
public enum ResponseStatus {

    /***
     *  成功
     */
    SUCCESS(200, "成功"),
    FAIL(500, "失败");

    public int code;
    public String message;

    ResponseStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public ResponseStatus setMessage(String message) {
        this.message = message;
        return this;
    }
}
