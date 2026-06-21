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
    SECKILL_SOLD_OUT("20001", "商品已售罄"),
    SECKILL_DUPLICATE("20002", "您已参与过此秒杀活动"),

    ;


    // 异常码
    private String errorCode;
    // 异常信息
    private String errorMessage;
}
