package com.gaoyxxx.seckill.user.service;

import com.gaoyxxx.seckill.common.utils.Response;
import com.gaoyxxx.seckill.user.model.vo.LoginUserReqVO;
import com.gaoyxxx.seckill.user.model.vo.LoginUserRspVO;
import com.gaoyxxx.seckill.user.model.vo.RegisterUserReqVO;
import com.gaoyxxx.seckill.user.model.vo.SendVerifyCodeReqVO;

/**
 * @Author: gaoyx
 * @Description: 用户业务
 * @CreateDateTime: 2026/6/22 1:45
 */
public interface UserService {

    /**
     * 用户注册
     * @param registerUserReqVO
     * @return
     */
    Response<?> register(RegisterUserReqVO registerUserReqVO);


    /**
     * 用户登录
     * @param loginUserReqVO
     * @return
     */
    Response<LoginUserRspVO> login(LoginUserReqVO loginUserReqVO);

    /**
     * 发送验证码
     * @param sendVerifyCodeReqVO
     * @return
     */
    Response<?> sendVerifyCode(SendVerifyCodeReqVO sendVerifyCodeReqVO);
}
