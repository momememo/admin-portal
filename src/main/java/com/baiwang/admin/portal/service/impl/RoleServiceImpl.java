package com.baiwang.admin.portal.service.impl;

import com.baiwang.admin.portal.bean.entity.Method;
import com.baiwang.admin.portal.bean.entity.Role;
import com.baiwang.admin.portal.common.util.RequestUtil;
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
     * @return
     */
    @Override
    public List<Role> getRoleList() {
        String requestId = RequestUtil.getRequestId();
        List<Role> roles = roleMapper.selectRoleList();
        log.info("{} --> role list: {}", requestId, roles);
        return roles;

    }

    /**
     * 新增角色
     *
     * @param role
     */
    @Override
    public void addRole(Role role) {
        String requestId = RequestUtil.getRequestId();
        log.info("{} --> add role : {}", requestId, role);
        roleMapper.insertRole(role);
    }

    /**
     * 根据id获取Role
     *
     * @param roleId
     * @return
     */
    @Override
    public Role getRoleById(String roleId) {
        return roleMapper.selectRoleById(roleId);
    }

    /**
     * 更新Role
     *
     * @param role
     */
    @Override
    public void updateRole(Role role) {
        String requestId = RequestUtil.getRequestId();
        log.info("{} -->update role : {}", requestId, role);
        roleMapper.updateRole(role);
    }

    /**
     * 删除接口
     *
     * @param roleId
     */
    @Override
    public void deleteRoleById(String roleId) {
        String requestId = RequestUtil.getRequestId();
        log.info("{} --> delete roleId : {}", requestId, roleId);
        roleMapper.deleteRoleById(roleId);
    }
}
