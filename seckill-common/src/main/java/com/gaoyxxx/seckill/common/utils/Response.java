package com.gaoyxxx.seckill.common.utils;

import com.gaoyxxx.seckill.common.exception.BaseExceptionInterface;
import com.gaoyxxx.seckill.common.exception.BizException;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: gaoyx
 * @Description: 相应参数工具类
 * @CreateDateTime: 2026/6/21 16:21
 */
@Data
public class Response<T> implements Serializable {

    // 是否成功，默认为 true
    private boolean success = true;
    // 错误码
    private String errorCode;
    // 错误信息
    private String errorMessage;
    // 响应数据
    private T data;

    // =================================== 成功响应 ===================================
    public static <T> Response<T> success() {
        Response<T> response = new Response<>();
        return response;
    }

    public static <T> Response<T> success(T data) {
        Response<T> response = new Response<>();
        response.setData(data);
        return response;
    }

    // =================================== 失败响应 ===================================
    public static <T> Response<T> fail() {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        return response;
    }

    public static <T> Response<T> fail(String errorMessage) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setErrorMessage(errorMessage);
        return response;
    }

    public static <T> Response<T> fail(String errorCode, String errorMessage) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setErrorCode(errorCode);
        response.setErrorMessage(errorMessage);
        return response;
    }

    public static <T> Response<T> fail(BizException bizException) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setErrorCode(bizException.getErrorCode());
        response.setErrorMessage(bizException.getErrorMessage());
        return response;
    }

    public static <T> Response<T> fail(BaseExceptionInterface baseExceptionInterface) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setErrorCode(baseExceptionInterface.getErrorCode());
        response.setErrorMessage(baseExceptionInterface.getErrorMessage());
        return response;
    }


}
