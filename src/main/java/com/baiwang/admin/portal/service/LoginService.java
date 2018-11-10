package com.baiwang.admin.portal.service;

import com.baiwang.admin.portal.bean.entity.User;
import com.baiwang.admin.portal.bean.result.Result;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginService {

    /**
     * 用户登录
     * @param user
     */
    Result login(User user, HttpServletRequest request, HttpServletResponse response);

    /**
     * 校验用户是否登录
     * @param request
     * @param response
     */
    void checkLogin(HttpServletRequest request, HttpServletResponse response);

    /**
     * 用户退出
     * @return
     */
    Result logout(HttpServletRequest request);
}
