package com.baiwang.admin.portal.controller;

import com.baiwang.admin.portal.bean.entity.Method;
import com.baiwang.admin.portal.bean.entity.User;
import com.baiwang.admin.portal.bean.request.MethodAddRequest;
import com.baiwang.admin.portal.bean.result.Result;
import com.baiwang.admin.portal.common.util.WebSessionUtils;
import com.baiwang.admin.portal.service.MethodService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/list/{index}")
    public String list(@PathVariable(value = "index") Integer index,
                       Model model) {
        methodService.list(index, model);
        return "method/list";
    }

    @RequestMapping(value = "/gotoAdd")
    public String gotoAdd(Model model) {
        methodService.gotoAdd(model);
        return "method/register";
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(@Valid MethodAddRequest method, BindingResult bindingResult) {
        validateBindingResult(bindingResult);
        Result result = methodService.addMethod(method);
        return result;
    }

    @RequestMapping(value = "/gotoUpdate/{methodId}", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable(value = "methodId") String methodId, Model model) {
        methodService.gotoUpdate(methodId, model);
        return "method/update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(Method method) {
        methodService.updateMethod(method);
        return "";
    }

    @RequestMapping(value = "/delete/{methodId}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("methodId") String methodId) {
        methodService.deleteMethodById(methodId);
        return "";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest request) {
        methodService.upload(request);
        return "";
    }


}
