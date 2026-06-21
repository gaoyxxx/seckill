package com.gaoyxxx.seckill.user.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * @Author: gaoyx
 * @Description: 用户状态枚举
 * @CreateDateTime: 2026/6/22 1:44
 */
@Getter
@AllArgsConstructor
public enum UserStatusEnum {

    DISABLE(0, "禁用"),
    ENABLE(1, "启用"),

    ;


    // 状态值
    private final Integer code;
    // 状态描述
    private final String description;
}
