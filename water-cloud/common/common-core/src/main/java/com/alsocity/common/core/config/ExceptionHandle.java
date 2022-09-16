package com.alsocity.common.core.config;

import com.alsocity.common.core.exception.BaseException;
import com.alsocity.common.core.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : 小凡
 * @date : create in 2021/9/12 11:26
 * description :
 **/
@RestController
@ControllerAdvice
@Slf4j
public class ExceptionHandle {

    @ExceptionHandler({Exception.class})
    public Response<Object> exceptionHandler(Exception e) {
        e.printStackTrace();
        log.error(e.getMessage());
        return Response.fail(e.getMessage());
    }

    @ExceptionHandler({BaseException.class})
    public Response<Object> baseExceptionHandler(BaseException e) {
        log.error(e.getMessage());
        if (e.getException() != null) {
            e.getException().printStackTrace();
        }
        return Response.fail(e.getMessage());
    }
}
