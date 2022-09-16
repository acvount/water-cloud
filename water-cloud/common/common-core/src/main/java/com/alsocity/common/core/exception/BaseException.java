package com.alsocity.common.core.exception;

import com.alsocity.common.core.exception.config.ExceptionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @author : 小凡
 * @date : create in 2021/7/22 14:30
 * description :
 **/
@Slf4j
@Getter
@NoArgsConstructor
public class BaseException extends Exception implements Serializable {

    private ExceptionType exceptionType;
    public int code;
    public String message;
    private Exception exception;


    public BaseException(ExceptionType exceptionType) {
        super();
        this.exceptionType = exceptionType;
        this.code = exceptionType.getCode();
        this.message = exceptionType.getMessage();
    }

    public BaseException(ExceptionType exceptionType, Exception e) {
        super();
        this.exceptionType = exceptionType;
        this.exception = e;
        this.code = exceptionType.getCode();
        this.message = exceptionType.getMessage();
    }

    public void print() {
        log.error("\ncode:{}\nmsg:{}\n", exceptionType.getCode(), exceptionType.getMessage());
    }
}
