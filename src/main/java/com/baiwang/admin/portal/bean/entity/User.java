package com.baiwang.admin.portal.bean.entity;

import com.baiwang.admin.portal.bean.base.BaseEntity;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @Description:  用户bean
 * @author: liyunfei
 * @date: 2018/9/3 16:06
 */
public class User extends BaseEntity {

    private Integer userId;
    private String username;
    private String phone;
    private String email;
    @NotEmpty(message = "登录用户名不能为空！")
    private String loginName;
    @NotEmpty(message = "用户密码不能为空！")
    private String loginPassword;
    private Integer roleId;
    private Integer groupId;
    private Integer status;

    public User() {
    }

    public User(Integer userId, String username, String phone, String email, String loginName, String loginPassword,
                Integer roleId, Integer groupId, Integer status) {
        this.userId = userId;
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.loginName = loginName;
        this.loginPassword = loginPassword;
        this.roleId = roleId;
        this.groupId = groupId;
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", loginName='" + loginName + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                ", roleId=" + roleId +
                ", groupId=" + groupId +
                ", status=" + status +
                '}';
    }
}
