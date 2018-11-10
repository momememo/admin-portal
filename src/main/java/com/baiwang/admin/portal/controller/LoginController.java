package com.baiwang.admin.portal.controller;

import com.baiwang.admin.portal.bean.entity.User;
import com.baiwang.admin.portal.bean.result.Result;
import com.baiwang.admin.portal.service.LoginService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description: 用户登录控制器
 * @author: liyunfei
 * @date: 2018/9/3 11:05
 */
@Controller
public class LoginController extends BaseController {

    /**
     * 1. 用户登录
     * 2. 用户退出
     */

    @Autowired
    private LoginService loginService;


    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response, User user, Model model) {
        user = loginService.login(user, request, response);
        model.addAttribute("loginUser", user);
        return "index";
    }
}
