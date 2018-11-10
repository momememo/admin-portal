package com.baiwang.admin.portal.controller;

import com.baiwang.admin.portal.bean.entity.User;
import com.baiwang.admin.portal.bean.result.Result;
import com.baiwang.admin.portal.common.constant.Constant;
import com.baiwang.admin.portal.common.util.WebSessionUtils;
import com.baiwang.admin.portal.service.LoginService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @ResponseBody
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Result login(HttpServletRequest request, HttpServletResponse response,
                        @Valid User user, BindingResult bindingResult) {
        validateBindingResult(bindingResult);
        Result result = loginService.login(user, request, response);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public Result login(HttpServletRequest request) {
        Result result = loginService.logout(request);
        return result;
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String login(Model model) {
        User userInfo = WebSessionUtils.getUserInfo();
        model.addAttribute(Constant.SESSION_USER, userInfo);
        return "index";
    }
}
