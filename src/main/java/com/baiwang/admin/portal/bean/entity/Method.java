package com.baiwang.admin.portal.bean.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @Description: Method
 * @author: liyunfei
 * @date: 2018/9/3 15:58
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Method {

    private Integer methodId; // id
    private String method; // 接口名称
    private String type; // 请求类型
    private String serviceInvocation; // 调用方式
    private String groupName; // 分组
    private String description; // 接口描述

    private String taxPropertyName; // 税号参数名
    private String passedHeaders; // 需要传递到后端的header参数名，用','分割

    private String requestName; // 请求bean名称
    private String responseName; // 响应bean名称
    @NotEmpty(message = "请求服务器地址不能为空")
    private String requestHost; // 请求服务器地址， 如果为Eureka调用，该值为 服务ID
    @NotEmpty(message = "接口地址不能为空")
    private String contextPath; // 接口地址
    private String requestUrl; // url
    private String docUrl; // 文档地址，不带后缀
    private String requestParserBeanName;
    private String conditionCheckerBeanName;
    private String requestInvokerBeanName;
    private String resultProcessorBeanName;
    private String status; // 状态 0-未审核 1-审核通过 2-审核拒绝
    private String creator; // 创建人
    private String auditor; // 审核人
    private Date createTime; // 创建时间
    private Date updateTime; // 修改时间
    private Date auditTime; // 审核时间

    public Integer getMethodId() {
        return methodId;
    }

    public void setMethodId(Integer methodId) {
        this.methodId = methodId;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getServiceInvocation() {
        return serviceInvocation;
    }

    public void setServiceInvocation(String serviceInvocation) {
        this.serviceInvocation = serviceInvocation;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTaxPropertyName() {
        return taxPropertyName;
    }

    public void setTaxPropertyName(String taxPropertyName) {
        this.taxPropertyName = taxPropertyName;
    }

    public String getPassedHeaders() {
        return passedHeaders;
    }

    public void setPassedHeaders(String passedHeaders) {
        this.passedHeaders = passedHeaders;
    }

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public String getResponseName() {
        return responseName;
    }

    public void setResponseName(String responseName) {
        this.responseName = responseName;
    }

    public String getRequestHost() {
        return requestHost;
    }

    public void setRequestHost(String requestHost) {
        this.requestHost = requestHost;
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getDocUrl() {
        return docUrl;
    }

    public void setDocUrl(String docUrl) {
        this.docUrl = docUrl;
    }

    public String getRequestParserBeanName() {
        return requestParserBeanName;
    }

    public void setRequestParserBeanName(String requestParserBeanName) {
        this.requestParserBeanName = requestParserBeanName;
    }

    public String getConditionCheckerBeanName() {
        return conditionCheckerBeanName;
    }

    public void setConditionCheckerBeanName(String conditionCheckerBeanName) {
        this.conditionCheckerBeanName = conditionCheckerBeanName;
    }

    public String getRequestInvokerBeanName() {
        return requestInvokerBeanName;
    }

    public void setRequestInvokerBeanName(String requestInvokerBeanName) {
        this.requestInvokerBeanName = requestInvokerBeanName;
    }

    public String getResultProcessorBeanName() {
        return resultProcessorBeanName;
    }

    public void setResultProcessorBeanName(String resultProcessorBeanName) {
        this.resultProcessorBeanName = resultProcessorBeanName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    @Override
    public String toString() {
        return "Method{" +
                "methodId=" + methodId +
                ", method='" + method + '\'' +
                ", type='" + type + '\'' +
                ", serviceInvocation='" + serviceInvocation + '\'' +
                ", groupName='" + groupName + '\'' +
                ", description='" + description + '\'' +
                ", taxPropertyName='" + taxPropertyName + '\'' +
                ", passedHeaders='" + passedHeaders + '\'' +
                ", requestName='" + requestName + '\'' +
                ", responseName='" + responseName + '\'' +
                ", requestHost='" + requestHost + '\'' +
                ", contextPath='" + contextPath + '\'' +
                ", requestUrl='" + requestUrl + '\'' +
                ", docUrl='" + docUrl + '\'' +
                ", requestParserBeanName='" + requestParserBeanName + '\'' +
                ", conditionCheckerBeanName='" + conditionCheckerBeanName + '\'' +
                ", requestInvokerBeanName='" + requestInvokerBeanName + '\'' +
                ", resultProcessorBeanName='" + resultProcessorBeanName + '\'' +
                ", status='" + status + '\'' +
                ", creator='" + creator + '\'' +
                ", auditor='" + auditor + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", auditTime=" + auditTime +
                '}';
    }
}