package com.baiwang.admin.portal.service;

import com.baiwang.admin.portal.bean.entity.Role;
import java.util.List;

public interface RoleService {

    /**
     * 获取Role列表
     * @return
     */
    List<Role> getRoleList();

    /**
     * 新增角色
     * @param role
     */
    void addRole(Role role);

    /**
     * 根据id获取Role
     * @param roleId
     * @return
     */
    Role getRoleById(String roleId);

    /**
     * 更新Role
     * @param role
     */
    void updateRole(Role role);

    /**
     * 删除接口
     * @param roleId
     */
    void deleteRoleById(String roleId);

}
