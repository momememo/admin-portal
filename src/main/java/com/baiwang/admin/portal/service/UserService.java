package com.baiwang.admin.portal.service;

import com.baiwang.admin.portal.bean.entity.User;
import java.util.List;

public interface UserService {

    /**
     * 获取User列表
     * @param requestId
     * @return
     */
    List<User> getUserList(String requestId);

    /**
     * 新增User
     * @param requestId
     * @param user
     */
    void addUser(String requestId, User user);

    /**
     * 根据id获取User
     * @param requestId
     * @param userId
     * @return
     */
    User getUserById(String requestId, String userId);

    /**
     * 更新User
     * @param requestId
     * @param user
     */
    void updateUser(String requestId, User user);

    /**
     * 删除接口
     * @param requestId
     * @param userId
     */
    void deleteUserById(String requestId, String userId);
}
