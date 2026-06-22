package com.gaoyxxx.seckill.user.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.gaoyxxx.seckill.common.domain.dataobject.UserDO;
import com.gaoyxxx.seckill.common.domain.mapper.UserDOMapper;
import com.gaoyxxx.seckill.common.enums.ResponseCodeEnum;
import com.gaoyxxx.seckill.common.exception.BizException;
import com.gaoyxxx.seckill.common.utils.Response;
import com.gaoyxxx.seckill.user.enums.LoginTypeEnum;
import com.gaoyxxx.seckill.user.enums.UserStatusEnum;
import com.gaoyxxx.seckill.user.model.vo.LoginUserReqVO;
import com.gaoyxxx.seckill.user.model.vo.LoginUserRspVO;
import com.gaoyxxx.seckill.user.model.vo.RegisterUserReqVO;
import com.gaoyxxx.seckill.user.service.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @Author: gaoyx
 * @Description:
 * @CreateDateTime: 2026/6/22 1:46
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserDOMapper userDOMapper;

    /**
     * 用户注册
     *
     * @param registerUserReqVO
     * @return
     */
    @Override
    public Response<?> register(RegisterUserReqVO registerUserReqVO) {
        String mobile = registerUserReqVO.getMobile();
        String password = registerUserReqVO.getPassword();
        String verifyCode = registerUserReqVO.getVerifyCode();

        // 1. 校验验证码
        // TODO: 验证码先写死 123456，后续开发验证码发送接口，再重构这里
        if (!"123456".equals(verifyCode)) {
            throw new BizException(ResponseCodeEnum.USER_VERIFY_CODE_ERROR);
        }

        // 2. 校验手机号是否已注册
        Long existUserId = userDOMapper.selectIdByMobile(mobile);
        if (Objects.nonNull(existUserId)) {
            throw new BizException(ResponseCodeEnum.USER_MOBILE_EXISTS);
        }

        // 3. 密码加密（使用 BCrypt 算法）
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);

        // 4. 构建用户实体，插入数据库
        UserDO userDO = UserDO.builder()
                .mobile(mobile)
                .password(encodedPassword)
                .nickname(generateNickname()) // 生成随机用户昵称
                .status(UserStatusEnum.ENABLED.getCode()) // 默认启用
                .build();

        userDOMapper.insertSelective(userDO);

        log.info("==> 用户注册成功, mobile: {}", mobile);

        return Response.success();
    }

    /**
     * 用户登录
     *
     * @param loginUserReqVO
     * @return
     */
    @Override
    public Response<LoginUserRspVO> login(LoginUserReqVO loginUserReqVO) {
        String mobile = loginUserReqVO.getMobile();
        Integer type = loginUserReqVO.getType();

        // 1. 根据手机号查询用户
        UserDO userDO = userDOMapper.selectByMobile(mobile);

        // 2. 判断用户是否存在
        if (Objects.isNull(userDO)) {
            throw new BizException(ResponseCodeEnum.USER_MOBILE_NOT_REGISTERED);
        }

        // 3. 根据用户登陆类型身份校验
        if (Objects.equals(type, LoginTypeEnum.PASSWORD.getCode())) {
            // 密码登录，校验密码是否正确
            checkPassword(loginUserReqVO.getPassword(), userDO.getPassword());
        } else {
            // 验证码登录，校验验证码是否正确
            checkVerifyCode(loginUserReqVO.getVerifyCode());
        }

        // 4. 校验用户状态（是否被封号）
        if (Objects.equals(userDO.getStatus(), UserStatusEnum.DISABLED.getCode())) {
            throw new BizException(ResponseCodeEnum.USER_STATUS_DISABLED);
        }

        // 5. SaToken 执行登录，传入用户 ID
        StpUtil.login(userDO.getId());

        // 6. 获取 token
        String token = StpUtil.getTokenValue();

        // 7. 构建返回结果
        LoginUserRspVO loginUserRspVO = LoginUserRspVO.builder()
                .token(token)
                .userInfo(LoginUserRspVO.UserInfo.builder()
                        .id(userDO.getId())
                        .nickname(userDO.getNickname())
                        .avatar(userDO.getAvatar())
                        .build())
                .build();

        log.info("==> 用户登录成功, userId: {}, mobile: {}", userDO.getId(), mobile);

        return Response.success(loginUserRspVO);
    }

    /**
     * 生成随机昵称
     * 格式：用户 + 6 位随机数字，如：用户382910
     *
     * @return 昵称
     */
    private String generateNickname() {
        return "用户" + RandomUtil.randomNumbers(6);
    }

    /**
     * 校验密码
     * @param password
     * @param encodedPassword
     */
    private void checkPassword(String password, String encodedPassword) {
        // 密码不能为空
        if (StrUtil.isBlank(password)) {
            throw new BizException(ResponseCodeEnum.USER_PASSWORD_ERROR);
        }

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        boolean matches = bCryptPasswordEncoder.matches(password, encodedPassword);
        if (!matches) {
            throw new BizException(ResponseCodeEnum.USER_PASSWORD_ERROR);
        }
    }

    /**
     * 校验验证码
     * @param verifyCode
     */
    private void checkVerifyCode(String verifyCode) {
        // 验证码不能为空
        if (StrUtil.isBlank(verifyCode)) {
            throw new BizException(ResponseCodeEnum.USER_VERIFY_CODE_ERROR);
        }

        // TODO: 验证码校验逻辑，后续开发验证码发送接口，再重构这里
        if (!"123456".equals(verifyCode)) {
            throw new BizException(ResponseCodeEnum.USER_VERIFY_CODE_ERROR);
        }
    }
}
