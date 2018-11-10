package com.baiwang.admin.portal.service;

import com.baiwang.admin.portal.bean.entity.Method;
import com.baiwang.admin.portal.bean.entity.User;
import com.baiwang.admin.portal.bean.result.Result;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;

public interface MethodService {

    /**
     * 新增接口
     * @param method
     */
    Result addMethod(Method method);

    /**
     * 更新method
     * @param method
     */
    void updateMethod(Method method);

    /**
     * 删除接口
     * @param methodId
     */
    void deleteMethodById(String methodId);

    /**
     * 上传
     * @param request
     */
    void upload(HttpServletRequest request);

    /**
     * 分页查询list
     * @param index
     * @param model
     */
    void list(Integer index, Model model);

    /**
     * 去更新页面
     * @param methodId
     * @param model
     */
    void gotoUpdate(String methodId, Model model);
}
