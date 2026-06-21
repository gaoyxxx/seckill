package com.gaoyxxx.seckill.app;

import com.gaoyxxx.seckill.common.domain.dataobject.UserDO;
import com.gaoyxxx.seckill.common.domain.mapper.UserDOMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author: gaoyx
 * @Description:
 * @CreateDateTime: 2026/6/21 12:26
 */
@SpringBootTest
public class UserTests {

    @Resource
    private UserDOMapper userDOMapper;

    /**
     * 添加一条用户记录
     */
    @Test
    void testInsterUser() {
        userDOMapper.insert(UserDO.builder()
                .nickname("gaoyx")
                .password("123")
                .mobile("12345678901")
                .status(1)
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build());
    }
}
