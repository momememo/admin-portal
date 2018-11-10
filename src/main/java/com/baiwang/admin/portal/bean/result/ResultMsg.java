package com.baiwang.admin.portal.bean.result;

import com.fasterxml.jackson.annotation.JsonInclude;


/**
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultMsg {
    private String errorCode;

    private String errorMessage;

    public ResultMsg(){}

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    private String successMessage;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ResultMsg(String errorCode, String errorMessage) {
        this.setErrorCode(errorCode);
        this.setErrorMessage(errorMessage);
    }

    public ResultMsg(String successMessage) {
        this.setSuccessMessage(successMessage);
    }
}
