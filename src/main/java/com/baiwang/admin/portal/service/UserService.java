package com.baiwang.admin.portal.service;

import com.baiwang.admin.portal.bean.entity.User;
import java.util.List;

public interface UserService {

    /**
     * 获取User列表
     * @return
     */
    List<User> getUserList();

    /**
     * 新增User
     * @param user
     */
    void addUser(User user);

    /**
     * 根据id获取User
     * @param userId
     * @return
     */
    User getUserById(String userId);

    /**
     * 更新User
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除接口
     * @param userId
     */
    void deleteUserById(String userId);
}
