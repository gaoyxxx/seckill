package com.gaoyxxx.seckill.common.aspect;

import java.lang.annotation.*;

/**
 * @Author: gaoyx
 * @Description:
 * @CreateDateTime: 2026/6/21 17:28
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
@Documented
public @interface ApiOperationLog {

    /**
     * API 功能描述
     * @return
     */
    String description() default "";
}
