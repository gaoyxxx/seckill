package com.gaoyxxx.seckill.user.model.vo;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

/**
 * @Author: gaoyx
 * @Description: 用户登录
 * @CreateDateTime: 2026/6/23 0:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginUserReqVO {

    /**
     * 手机号（充当登陆账号）
     */
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式错误")
    private String mobile;

    /**
     * 登录类型 1: 密码登录   2: 验证码登录
     */
    private Integer type;

    /**
     * 密码   type=1 时必填
     */
    private String password;

    /**
     * 验证码  type=2 时必填
     */
    private String verifyCode;
}
