package com.gaoyxxx.seckill.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: gaoyx
 * @Description: 秒杀系统启动类
 * @CreateDateTime: 2026/6/21 1:20
 */
@SpringBootApplication
@ComponentScan({"com.gaoyxxx.seckill.*"}) // 多模块项目中，必需手动指定扫描 com.gaoyxxx.seckill 包下面的所有类
public class SeckillApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeckillApplication.class, args);
    }
}
