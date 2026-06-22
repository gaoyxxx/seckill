package com.gaoyxxx.seckill.common.enums;

import com.gaoyxxx.seckill.common.exception.BaseExceptionInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: gaoyx
 * @Description:
 * @CreateDateTime: 2026/6/21 16:29
 */
@Getter
@AllArgsConstructor
public enum ResponseCodeEnum implements BaseExceptionInterface {

    // ----------- 通用异常状态码 -----------
    SYSTEM_ERROR("10000", "出错了...我也不知道啥错，联系管理员吧..."),
    PARAM_NOT_VALID("10001", "参数不合法"),



    // ----------- 业务异常状态码 -----------

    // ----------- 用户模块异常状态码 -----------
    USER_MOBILE_EXISTS("20001", "该手机号已注册"),
    USER_VERIFY_CODE_ERROR("20002", "验证码错误"),
    USER_MOBILE_NOT_REGISTERED("20003", "该手机号未注册"),
    USER_PASSWORD_ERROR("20004", "密码错误"),
    USER_STATUS_DISABLED("20005", "用户已禁用，请联系管理员"),


    ;


    // 异常码
    private String errorCode;
    // 异常信息
    private String errorMessage;
}
