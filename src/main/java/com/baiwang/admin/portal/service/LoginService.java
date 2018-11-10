package com.baiwang.admin.portal.service;

import com.baiwang.admin.portal.bean.entity.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginService {

    /**
     * 用户登录
     * @param requestId
     * @param user
     */
    User login(String requestId, User user, HttpServletRequest request, HttpServletResponse response);

    /**
     * 校验用户是否登录
     * @param request
     * @param response
     */
    void checkLogin(HttpServletRequest request, HttpServletResponse response);
}
