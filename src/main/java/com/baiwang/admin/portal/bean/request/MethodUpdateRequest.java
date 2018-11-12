package com.baiwang.admin.portal.bean.request;

import com.baiwang.admin.portal.bean.entity.Method;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @Description:
 * @author: liyunfei
 * @date: 2018/11/10 14:38
 */
public class MethodUpdateRequest extends Method {

    @NotNull(message = "接口ID不能为空")
    private Integer methodId; // id
    @NotEmpty(message = "接口名称不能为空")
    private String method; // 接口名称
    @NotEmpty(message = "请求类型不能为空")
    private String requestType; // 请求类型
    @NotEmpty(message = "调用方式不能为空")
    private String serviceInvocation; // 调用方式
    @NotEmpty(message = "接口分组不能为空")
    private String groupName; // 分组
    @NotEmpty(message = "请求服务器地址不能为空")
    private String requestHost; // 请求服务器地址， 如果为Eureka调用，该值为 服务ID
    @NotEmpty(message = "接口地址不能为空")
    private String contextPath; // 接口地址
    @NotEmpty(message = "接口状态不能为空")
    private String status;

    @Override
    public Integer getMethodId() {
        return methodId;
    }

    @Override
    public void setMethodId(Integer methodId) {
        this.methodId = methodId;
    }

    @Override
    public String getMethod() {
        return method;
    }

    @Override
    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String getRequestType() {
        return requestType;
    }

    @Override
    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    @Override
    public String getServiceInvocation() {
        return serviceInvocation;
    }

    @Override
    public void setServiceInvocation(String serviceInvocation) {
        this.serviceInvocation = serviceInvocation;
    }

    @Override
    public String getGroupName() {
        return groupName;
    }

    @Override
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

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

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }
}
