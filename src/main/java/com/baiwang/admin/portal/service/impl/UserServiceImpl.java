package com.baiwang.admin.portal.service.impl;

import com.baiwang.admin.portal.bean.entity.User;
import com.baiwang.admin.portal.common.util.MD5Util;
import com.baiwang.admin.portal.mapper.UserMapper;
import com.baiwang.admin.portal.service.UserService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * @param requestId
     * @return
     */
    @Override
    public List<User> getUserList(String requestId) {
        return userMapper.selectUserList();
    }

    /**
     * 新增角色
     *
     * @param requestId
     * @param user
     */
    @Override
    public void addUser(String requestId, User user) {
        String loginPassword = user.getLoginPassword();
        // md5加密
        user.setLoginPassword(MD5Util.encrypt(loginPassword));
        userMapper.insertUser(user);
    }

    /**
     * 根据id获取User
     *
     * @param requestId
     * @param userId
     * @return
     */
    @Override
    public User getUserById(String requestId, String userId) {
        return userMapper.selectUserById(userId);
    }

    /**
     * 更新User
     *
     * @param requestId
     * @param user
     */
    @Override
    public void updateUser(String requestId, User user) {
        userMapper.updateUser(user);
    }

    /**
     * 删除接口
     *
     * @param requestId
     * @param userId
     */
    @Override
    public void deleteUserById(String requestId, String userId) {
        userMapper.deleteUserById(userId);
    }
}
