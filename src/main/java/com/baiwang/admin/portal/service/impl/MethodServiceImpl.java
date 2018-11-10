package com.baiwang.admin.portal.service.impl;

import com.baiwang.admin.portal.bean.entity.Method;
import com.baiwang.admin.portal.bean.entity.Role;
import com.baiwang.admin.portal.bean.entity.User;
import com.baiwang.admin.portal.bean.result.Result;
import com.baiwang.admin.portal.bean.result.ResultBuilder;
import com.baiwang.admin.portal.bean.result.ResultMsg;
import com.baiwang.admin.portal.common.exception.BopErrorEnum;
import com.baiwang.admin.portal.common.exception.BopException;
import com.baiwang.admin.portal.common.util.RequestUtil;
import com.baiwang.admin.portal.common.util.WebSessionUtils;
import com.baiwang.admin.portal.mapper.MethodMapper;
import com.baiwang.admin.portal.mapper.RoleMapper;
import com.baiwang.admin.portal.mapper.UserMapper;
import com.baiwang.admin.portal.service.MethodService;
import com.baiwang.moirai.utils.JacksonUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

/**
 * @Description:
 * @author: liyunfei
 * @date: 2018/9/3 16:11
 */
@Service
public class MethodServiceImpl implements MethodService {

    @Autowired
    private MethodMapper methodMapper;

    @Autowired
    private RoleMapper roleMapper;

    private Integer SIZE = 10;

    private static Logger log = LoggerFactory.getLogger(MethodServiceImpl.class);


    /**
     * 新增接口
     *
     * @param method
     */
    @Override
    public Result addMethod(Method method) {
        String requestId = RequestUtil.getRequestId();
        log.info("{} --> add method : {}", requestId, method);

        ResultBuilder builder = ResultBuilder.newResult().setRequestId(requestId);
        Result result;
        ResultMsg msg = new ResultMsg();
        msg.setSuccessMessage("接口添加成功！");
        Method m1 = methodMapper.selectMethodByMethodName(method.getMethod());
        if (m1 != null) {
            throw new BopException(BopErrorEnum.BOP_INCORRECT_LOGIN_INFO);
        }

        if (method.getMethod() == null) {
            method.setMethod(UUID.randomUUID().toString());
            method.setStatus("0");
        } else {
            method.setStatus("1");  // 0-审核中， 1-审核通过, 2-审核拒绝
            method.setAuditor(method.getCreator());
            method.setAuditTime(new Date());
        }
        try {
            methodMapper.insertMethod(method);
            result = builder.buildSuccess();
        } catch (Exception e) {
            result = builder.buildError();
            log.error("{} --> [addMethod] Error: {}", requestId, e.getMessage(), e);
        }
        return result;
    }


    /**
     * 更新method
     *
     * @param method
     */
    @Override
    public void updateMethod(Method method) {
        String requestId = RequestUtil.getRequestId();
        log.info("{} -->update method : {}", requestId, method);
        methodMapper.updateMethod(method);
    }

    /**
     * 删除接口
     *
     * @param methodId
     */
    @Override
    public void deleteMethodById(String methodId) {
        String requestId = RequestUtil.getRequestId();
        log.info("{} --> delete methodId : {}", requestId, methodId);
        methodMapper.deleteMethodById(methodId);
    }

    /**
     * 上传
     *
     * @param request
     */
    @Override
    public void upload(HttpServletRequest request) {

    }

    /**
     * 接口列表
     *
     * @param index
     * @param model
     */
    @Override
    public void list(Integer index, Model model) {

        List<Method> methods = new ArrayList<>();
        int count = 0;
        User user = WebSessionUtils.getUserInfo();
        Integer roleId = user.getRoleId();
        if (roleId != null) {
            if (roleId == 1) {
                Integer start = (index - 1) * SIZE;
                count = methodMapper.selectCountMethods(null);
                methods = methodMapper.selectMethodList(null, start, SIZE);
            } else {
                Role role = roleMapper.selectRoleById(roleId.toString());
                if (role != null) {
                    Integer groupId = user.getGroupId();
                    methods = methodMapper.selectMethodList(groupId.toString(), index, SIZE);
                    count = methodMapper.selectCountMethods(groupId.toString());
                }
            }
        }
        Integer total = count % SIZE == 0 ? count / SIZE : (count / SIZE) + 1;
        model.addAttribute("methods", methods);
        model.addAttribute("loginUser", user);
        model.addAttribute("indexPage", index);
        model.addAttribute("totalPage", total);
    }

    /**
     * 去更新页面
     *
     * @param methodId
     * @param model
     */
    @Override
    public void gotoUpdate(String methodId, Model model) {
        String requestId = RequestUtil.getRequestId();
        log.info("{} --> goto update method, methodId : {}", requestId, methodId);
        User user = WebSessionUtils.getUserInfo();
        Method method = methodMapper.selectMethodById(methodId);
        log.info("{} --> goto update method, result", JacksonUtil.beanToString(method));
        model.addAttribute("loginUser", user);
        model.addAttribute("method", method);
        model.addAttribute("type222", "post");
    }
}
