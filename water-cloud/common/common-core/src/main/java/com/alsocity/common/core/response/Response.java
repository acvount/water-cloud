package com.alsocity.common.core.response;

import com.alsocity.common.core.response.config.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : 小凡
 * @date : create in 2021/7/22 15:11
 * description : 返回类
 **/
@Builder
@Data
@AllArgsConstructor
public class Response<T> implements Serializable {

    public T data;
    public int code;
    public String msg;

    public Response(T data) {
        ResponseStatus responseStatus = ResponseStatus.SUCCESS;
        code = responseStatus.code;
        msg = responseStatus.message;
        this.data = data;
    }

    public Response(ResponseStatus responseStatus, T data) {
        code = responseStatus.code;
        msg = responseStatus.message;
        this.data = data;
    }

    public static Response<Object> ok(Object data) {
        return Response.builder().code(ResponseStatus.SUCCESS.code).msg(ResponseStatus.SUCCESS.message).data(data).build();
    }

    public static Response<Object> ok(Object data, String msg) {
        return Response.builder().code(ResponseStatus.SUCCESS.code).msg(msg).data(data).build();
    }

    public static Response<Object> fail(String msg) {
        return Response.builder().code(ResponseStatus.FAIL.code).msg(msg).build();
    }

    public static Response<Object> fail() {
        return Response.builder().code(ResponseStatus.FAIL.code).msg(ResponseStatus.FAIL.message).build();
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
