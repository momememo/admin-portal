package com.baiwang.admin.portal.bean.entity;

import com.baiwang.admin.portal.bean.base.BaseEntity;

/**
 * @Description: 权限角色bean
 * @author: liyunfei
 * @date: 2018/9/3 16:04
 */
public class Role extends BaseEntity {

    private Integer roleId;
    private String roleName;
    private Integer roleType;
    private String desc;

    public Role() {
    }

    public Role(Integer roleId, String roleName, Integer roleType, String desc) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleType = roleType;
        this.desc = desc;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleType=" + roleType +
                ", desc='" + desc + '\'' +
                '}';
    }
}
