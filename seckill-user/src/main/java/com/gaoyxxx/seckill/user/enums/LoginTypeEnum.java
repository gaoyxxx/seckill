package com.gaoyxxx.seckill.user.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: gaoyx
 * @Description: 登录类型枚举
 * @CreateDateTime: 2026/6/23 0:01
 */
@Getter
@AllArgsConstructor
public enum LoginTypeEnum {

    PASSWORD(1, "密码登录"),
    VERIFY_CODE(2, "验证码登录"),


    ;
    // 类型值
    private final Integer code;
    // 类型描述
    private final String description;
}
