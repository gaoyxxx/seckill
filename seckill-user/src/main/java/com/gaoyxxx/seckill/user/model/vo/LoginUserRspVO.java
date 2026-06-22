package com.gaoyxxx.seckill.user.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: gaoyx
 * @Description:
 * @CreateDateTime: 2026/6/23 0:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginUserRspVO {

    /**
     * token 令牌
     */
    private String token;

    /**
     * 用户信息
     */
    private UserInfo userInfo;



    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class UserInfo {

        /**
         * 用户 ID
         */
        private Long id;

        /**
         * 用户昵称
         */
        private String nickname;

        /**
         * 用户头像
         */
        private String avatar;
    }

}
