package com.baiwang.admin.portal.controller;

import com.baiwang.admin.portal.bean.entity.Method;
import com.baiwang.admin.portal.bean.entity.User;
import com.baiwang.admin.portal.bean.result.Result;
import com.baiwang.admin.portal.common.constant.Param;
import com.baiwang.admin.portal.common.exception.BopErrorEnum;
import com.baiwang.admin.portal.common.exception.BopException;
import com.baiwang.admin.portal.common.util.WebSessionUtils;
import com.baiwang.admin.portal.service.MethodService;
import com.baiwang.moirai.utils.JacksonUtil;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 接口控制器
 * @author: liyunfei
 * @date: 2018/9/3 10:47
 */
@Controller
@RequestMapping("method")
public class MethodController extends BaseController {

    /**
     * 1. 接口列表
     * 2. 添加接口
     * 3. 修改接口
     * 4. 删除接口
     * 5. 上传下载
     */
    @Autowired
    private MethodService methodService;

    private static Logger log = LoggerFactory.getLogger(MethodController.class);

    @RequestMapping(value = "/list/{index}")
    public String list(@RequestParam(value = "requestId", required = false) String requestId,
                       @PathVariable(value = "index") Integer index,
                       Model model) {
        methodService.list(requestId, index, model);
        return "method/list";
    }

    @RequestMapping(value = "/gotoAdd")
    public String gotoAdd(Model model) {
        User user = WebSessionUtils.getUserInfo();
        model.addAttribute("loginUser", user);
        return "method/register";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(Method method,
                      @RequestParam(value = "requestId", required = false) String requestId) {
        log.info("{} --> add method : {}", requestId, method);
        Result result = methodService.addMethod(requestId, method);
        return result;
    }

    @RequestMapping(value = "/gotoUpdate/{methodId}", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable(value = "methodId") String methodId,
                             @RequestParam(value = "requestId", required = false) String requestId, Model model) {
        log.info("{} --> goto update method, methodId : {}", requestId, methodId);
        User user = WebSessionUtils.getUserInfo();
        Method method = methodService.getMethodById(requestId, methodId);
        log.info("{} --> goto update method, result", JacksonUtil.beanToString(method));
        model.addAttribute("loginUser", user);
        model.addAttribute("method", method);
        model.addAttribute("type222", "post");
        return "method/update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(Method method,
                         @RequestParam(value = "requestId", required = false) String requestId) {
        log.info("{} -->update method : {}", requestId, method);
        methodService.updateMethod(requestId, method);
        return "";
    }

    @RequestMapping(value = "/delete/{methodId}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("methodId") String methodId,
                         @RequestParam(value = "requestId", required = false) String requestId) {
        log.info("{} --> delete methodId : {}", requestId, methodId);
        methodService.deleteMethodById(requestId, methodId);
        return "";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest request,
                         @RequestParam(value = "requestId", required = false) String requestId) {
        methodService.upload(requestId, request);
        return "";
    }


}
