package com.alsocity.common.core.exception.config;

import java.io.Serializable;

/**
 * @author : 小凡
 * @date : create in 2021/7/22 14:48
 * description :
 **/
public enum ExceptionType implements Serializable {

    /***
     * 参数
     */
    Parameter_Error(10100, "入参错误"),


    /***
     * Token
     */
    Token_Invalid(10200, "Token失效"),
    Token_Not_Found(10201, "缺失Token | 未登录");


    private int code;
    private String message;

    ExceptionType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public ExceptionType setMessage(String message) {
        this.message = message;
        return this;
    }


}
