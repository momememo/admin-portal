package com.baiwang.admin.portal.service.impl;

import com.baiwang.admin.portal.bean.entity.User;
import com.baiwang.admin.portal.bean.result.Result;
import com.baiwang.admin.portal.bean.result.ResultBuilder;
import com.baiwang.admin.portal.common.constant.Constant;
import com.baiwang.admin.portal.common.exception.BopErrorEnum;
import com.baiwang.admin.portal.common.exception.BopException;
import com.baiwang.admin.portal.common.util.MD5Util;
import com.baiwang.admin.portal.common.util.RequestUtil;
import com.baiwang.admin.portal.common.util.WebSessionUtils;
import com.baiwang.admin.portal.mapper.UserMapper;
import com.baiwang.admin.portal.service.UserService;
import java.security.cert.TrustAnchor;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.pkcs11.wrapper.Constants;

/**
 * @Description:
 * @author: liyunfei
 * @date: 2018/8/29 9:48
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    /**
     * 获取User列表
     *
     * @return
     */
    @Override
    public List<User> getUserList() {
        String requestId = RequestUtil.getRequestId();
        List<User> users = userMapper.selectUserList();
        log.info("{} --> user list: {}", requestId, users);
        return users;
    }

    /**
     * 新增用户
     *
     * @param user
     */
    @Override
    public Result addUser(User user) {
        String requestId = RequestUtil.getRequestId();
        log.info("{} --> add user : {}", requestId, user);
        // 检查用户登录名是否已经被占用
        User u1 = userMapper.selectUserByLoginName(user.getLoginName());
        if (u1 != null) {
            throw new BopException(BopErrorEnum.BOP_LOGIN_NAME_REGISTERED);
        }

        String loginPassword = user.getLoginPassword();
        // md5加密
        user.setLoginPassword(MD5Util.encrypt(loginPassword));
        try {
            userMapper.insertUser(user);
        } catch (Exception e) {
            throw new BopException(BopErrorEnum.BOP_INTERNAL_ERROR);
        }

        // 放入session
        user = userMapper.selectUserByLoginName(user.getLoginName());
        WebSessionUtils.setAttribute(Constant.SESSION_USER, user);
        return ResultBuilder.newResult().setRequestId(requestId).buildSuccess();

    }

    /**
     * 根据id获取User
     *
     * @param userId
     * @return
     */
    @Override
    public User getUserById(String userId) {
        return userMapper.selectUserById(userId);
    }

    /**
     * 更新User
     *
     * @param user
     */
    @Override
    public void updateUser(User user) {
        String requestId = RequestUtil.getRequestId();
        log.info("{} -->update user : {}", requestId, user);
        userMapper.updateUser(user);
    }

    /**
     * 删除接口
     *
     * @param userId
     */
    @Override
    public void deleteUserById(String userId) {
        String requestId = RequestUtil.getRequestId();
        log.info("{} --> delete userId : {}", requestId, userId);
        userMapper.deleteUserById(userId);
    }
}
