package com.baiwang.admin.portal.service;

import com.baiwang.admin.portal.bean.entity.Role;
import java.util.List;

public interface RoleService {

    /**
     * 获取Role列表
     * @param requestId
     * @return
     */
    List<Role> getRoleList(String requestId);

    /**
     * 新增角色
     * @param requestId
     * @param role
     */
    void addRole(String requestId, Role role);

    /**
     * 根据id获取Role
     * @param requestId
     * @param roleId
     * @return
     */
    Role getRoleById(String requestId, String roleId);

    /**
     * 更新Role
     * @param requestId
     * @param role
     */
    void updateRole(String requestId, Role role);

    /**
     * 删除接口
     * @param requestId
     * @param roleId
     */
    void deleteRoleById(String requestId, String roleId);

}
