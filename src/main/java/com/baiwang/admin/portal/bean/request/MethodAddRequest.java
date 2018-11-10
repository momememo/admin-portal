package com.baiwang.admin.portal.bean.request;

import com.baiwang.admin.portal.bean.entity.Method;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @Description:
 * @author: liyunfei
 * @date: 2018/11/10 14:38
 */
public class MethodAddRequest extends Method {

    @NotEmpty(message = "请求服务器地址不能为空")
    private String requestHost; // 请求服务器地址， 如果为Eureka调用，该值为 服务ID
    @NotEmpty(message = "接口地址不能为空")
    private String contextPath; // 接口地址

    @Override
    public String getRequestHost() {
        return requestHost;
    }

    @Override
    public void setRequestHost(String requestHost) {
        this.requestHost = requestHost;
    }

    @Override
    public String getContextPath() {
        return contextPath;
    }

    @Override
    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }
}
