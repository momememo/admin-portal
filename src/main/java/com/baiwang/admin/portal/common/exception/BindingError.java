package com.baiwang.admin.portal.common.exception;

/**
 * @Description:
 * @author: liyunfei
 * @date: 2018/11/10 12:29
 */
public class BindingError {

    private String field;
    private String message;

    public BindingError() {
    }

    public BindingError(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
