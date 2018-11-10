package com.baiwang.admin.portal.service.impl;

import com.baiwang.admin.portal.bean.entity.Method;
import com.baiwang.admin.portal.bean.entity.Role;
import com.baiwang.admin.portal.mapper.RoleMapper;
import com.baiwang.admin.portal.service.RoleService;
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
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    private static Logger log = LoggerFactory.getLogger(RoleServiceImpl.class);

    /**
     * 获取Role列表
     *
     * @param requestId
     * @return
     */
    @Override
    public List<Role> getRoleList(String requestId) {
        return roleMapper.selectRoleList();
    }

    /**
     * 新增角色
     *
     * @param requestId
     * @param role
     */
    @Override
    public void addRole(String requestId, Role role) {
        roleMapper.insertRole(role);
    }

    /**
     * 根据id获取Role
     *
     * @param requestId
     * @param roleId
     * @return
     */
    @Override
    public Role getRoleById(String requestId, String roleId) {
        return roleMapper.selectRoleById(roleId);
    }

    /**
     * 更新Role
     *
     * @param requestId
     * @param role
     */
    @Override
    public void updateRole(String requestId, Role role) {
        roleMapper.updateRole(role);
    }

    /**
     * 删除接口
     *
     * @param requestId
     * @param roleId
     */
    @Override
    public void deleteRoleById(String requestId, String roleId) {
        roleMapper.deleteRoleById(roleId);
    }
}
