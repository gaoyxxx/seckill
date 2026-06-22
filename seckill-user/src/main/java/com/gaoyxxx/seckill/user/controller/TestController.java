package com.gaoyxxx.seckill.user.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.gaoyxxx.seckill.common.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: gaoyx
 * @Description:
 * @CreateDateTime: 2026/6/23 0:42
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @PostMapping("/isLogin")
    public Response<?> isLogin() {
        // 调用 SaToken 提供的方法，判断当前请求是否已登录
        boolean isLogin = StpUtil.isLogin();

        if (isLogin) {
            // 已登录，获取当前登录的用户 ID
            long loginId = StpUtil.getLoginIdAsLong();
            log.info("==> 当前已登录, userId: {}", loginId);
            return Response.success("当前登录用户 ID: " + loginId);
        } else {
            // 未登录
            return Response.success("当前未登录");
        }
    }
}
