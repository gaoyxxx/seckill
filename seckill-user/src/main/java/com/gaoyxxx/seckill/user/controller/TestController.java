package com.gaoyxxx.seckill.user.controller;

import com.gaoyxxx.seckill.common.aspect.ApiOperationLog;
import com.gaoyxxx.seckill.common.enums.ResponseCodeEnum;
import com.gaoyxxx.seckill.common.exception.BizException;
import com.gaoyxxx.seckill.common.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author: gaoyx
 * @Description:
 * @CreateDateTime: 2026/6/21 17:38
 */
@RestController
@Slf4j
public class TestController {

    @GetMapping("/test/response")
    @ApiOperationLog(description = "测试返回值")
    public Response<String> testResponse(@RequestParam String name) {
        return Response.success("hello " + name);
    }

    @GetMapping("/test/bizException")
    @ApiOperationLog(description = "测试业务异常")
    public Response<String> testBizException() {
        throw new BizException(ResponseCodeEnum.SECKILL_DUPLICATE);
    }

    @GetMapping("/test/systenException")
    @ApiOperationLog(description = "测试系统异常")
    public Response<String> testSystenException() {
        int i = 1 / 0;
        return Response.success("草泥马");
    }

}
