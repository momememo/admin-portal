package com.baiwang.admin.portal.common.exception;

import org.apache.commons.lang.StringUtils;

/**
 * @Description:
 * @author: liyunfei
 * @date: 2018/8/29 16:10
 */
public class BopException extends RuntimeException {

    private String requestId;
    private String code;
    private String message;
    private Exception cause;
    private BopErrorEnum errorEnum;

    public BopException() {
    }

    public BopException(String message) {
        this.message = message;
    }

    public BopException(BopErrorEnum errorEnum) {
        this.errorEnum = errorEnum;
    }

    public BopException(String requestId, BopErrorEnum errorEnum) {
        this.requestId = requestId;
        this.errorEnum = errorEnum;
    }

    public BopException(String requestId,  BopErrorEnum errorEnum, Exception cause) {
        this.requestId = requestId;
        this.cause = cause;
        this.errorEnum = errorEnum;
    }

    public BopException(String requestId, BopErrorEnum errorEnum, String message) {
        this.requestId = requestId;
        this.message = message;
        this.errorEnum = errorEnum;
    }

    public BopException(String requestId, String message) {
        this.requestId = requestId;
        this.message = message;
    }

    public BopException(String requestId, String code, String message) {
        this.requestId = requestId;
        this.code = code;
        this.message = message;
    }

    public BopException(String requestId, String code, String message, Exception cause) {
        this.requestId = requestId;
        this.code = code;
        this.message = message;
        this.cause = cause;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Exception getCause() {
        return cause;
    }

    public void setCause(Exception cause) {
        this.cause = cause;
    }

    public BopErrorEnum getErrorEnum() {
        return errorEnum;
    }

    public void setErrorEnum(BopErrorEnum errorEnum) {
        this.errorEnum = errorEnum;
    }

    public String getErrorMsg() {
        StringBuffer msg = new StringBuffer();
        if (this.errorEnum != null) {
            msg.append(errorEnum.getMsg());
        }
        if (!StringUtils.isEmpty(message)) {
            msg = StringUtils.isEmpty(msg.toString()) ? msg.append(message) : msg.append(",").append(message);
        }
        return msg.toString();
    }
}
