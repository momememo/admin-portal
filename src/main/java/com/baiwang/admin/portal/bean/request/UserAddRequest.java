package com.baiwang.admin.portal.bean.request;

import com.baiwang.admin.portal.bean.entity.User;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @Description:
 * @author: liyunfei
 * @date: 2018/11/10 14:36
 */
public class UserAddRequest extends User {

    @NotEmpty(message = "用户名昵称不能为空")
    private String username;
    @NotEmpty(message = "登录用户名不能为空")
    private String loginName;
    @NotEmpty(message = "用户密码不能为空")
    private String loginPassword;

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getLoginName() {
        return loginName;
    }

    @Override
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Override
    public String getLoginPassword() {
        return loginPassword;
    }

    @Override
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }
}
