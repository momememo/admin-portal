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
     * @param requestId
     * @param method
     */
    Result addMethod(String requestId, Method method);

    /**
     * 根据id获取接口
     * @param requestId
     * @param methodId
     * @return
     */
    Method getMethodById(String requestId, String methodId);

    /**
     * 更新method
     * @param requestId
     * @param method
     */
    void updateMethod(String requestId, Method method);

    /**
     * 删除接口
     * @param requestId
     * @param methodId
     */
    void deleteMethodById(String requestId, String methodId);

    /**
     * 上传
     * @param requestId
     * @param request
     */
    void upload(String requestId, HttpServletRequest request);

    /**
     * 分页查询list
     * @param requestId
     * @param index
     * @param model
     */
    void list(String requestId, Integer index, Model model);
}
