package com.baiwang.admin.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description: healthy
 * @author: liyunfei
 * @date: 2018/8/28 20:44
 */
@Controller
public class IndexController extends BaseController{

    @GetMapping("/healthy")
    public String healthy() {
        return "bwhealthy";
    }

    @RequestMapping(value = "/")
    public String test() {
        return "login";
    }
}
