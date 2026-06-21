package com.gaoyxxx.seckill.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: gaoyx
 * @Description: 业务异常
 * @CreateDateTime: 2026/6/21 16:08
 */
@Getter
@Setter
public class BizException extends RuntimeException {
    // 异常码
    private String errorCode;
    // 异常信息
    private String errorMessage;

    public BizException(BaseExceptionInterface baseExceptionInterface) {
        this.errorCode = baseExceptionInterface.getErrorCode();
        this.errorMessage = baseExceptionInterface.getErrorMessage();
    }

}
