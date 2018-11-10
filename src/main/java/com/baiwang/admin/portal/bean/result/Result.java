package com.baiwang.admin.portal.bean.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;

/**
 * Created by wwm on 2017/8/3.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> implements Serializable {
    private T model;

    private boolean isSuccess;

    private ResultMsg resultMsg;

    private String requestId;

    public Result(){}

    public Result(T model, boolean isSuccess, String requestId) {
        this.model = model;
        this.isSuccess = isSuccess;
        this.requestId = requestId;
    }

    public Result(T model, boolean isSuccess, ResultMsg resultMsg, String requestId) {
        this.model = model;
        this.isSuccess = isSuccess;
        this.resultMsg = resultMsg;
        this.requestId = requestId;
    }

    public T getModel() {
        return this.model;
    }

    public ResultMsg getMessage() {
        return this.resultMsg;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
