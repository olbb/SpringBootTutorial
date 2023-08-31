package com.example.demo.common;

import lombok.Builder;
import lombok.Getter;

/**
 * @author JuanLv created at 2023/8/30
 */
@Builder
@Getter
public class ResponseResult<T> {

    private long timestamp;
    private String status;
    private String message;
    private T data;

    public static <T> ResponseResult<T> success() {
        return success(null);
    }

    public static <T> ResponseResult<T> success(T data) {
        return ResponseResult.<T>builder().
                status(ResponseStatus.SUCCESS.getCode()).
                message(ResponseStatus.SUCCESS.getMessage()).
                data(data).
                timestamp(System.currentTimeMillis()).
                build();
    }

    public static <T> ResponseResult<T> failure(String message) {
        return failure(null, null , message);
    }

    public static <T> ResponseResult<T> failure(T data, String code, String message) {
        return ResponseResult.<T>builder().
                status(code).
                message(message).
                data(data).
                timestamp(System.currentTimeMillis()).
                build();
    }






}
