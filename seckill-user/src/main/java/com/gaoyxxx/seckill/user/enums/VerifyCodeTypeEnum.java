package com.gaoyxxx.seckill.user.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: gaoyx
 * @Description:
 * @CreateDateTime: 2026/6/23 1:29
 */
@Getter
@AllArgsConstructor
public enum VerifyCodeTypeEnum {

    REGISTER(1, "register", "注册"),
    LOGIN(2, "login", "登录");

    // 类型值
    private final Integer code;
    // 场景标识（用于拼接 Redis Key）
    private final String purpose;
    // 类型描述
    private final String description;

    public static VerifyCodeTypeEnum valueOf(Integer code) {
        for (VerifyCodeTypeEnum typeEnum : VerifyCodeTypeEnum.values()) {
            if (typeEnum .code.equals(code)) {
                return typeEnum;
            }
        }
        return null;
    }

}
