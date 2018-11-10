package com.baiwang.admin.portal.bean.result;

/**
 * Created by wwm on 2017/8/3.
 */
public class ResultBuilder<T> {
    private T model;

    private boolean isSuccess;

    private ResultMsg resultMsg;

    private String requestId;

    public static ResultBuilder newResult() {
        return new ResultBuilder();
    }

    public Result build() {
        return new Result(this.model, this.isSuccess, this.resultMsg, requestId);
    }

    public Result buildError() {
        return new Result(null, false, this.resultMsg, requestId);
    }

    public Result buildSuccess() {
        return new Result(this.model, true, requestId);
    }

    public ResultBuilder setModel(T model) {
        this.model = model;
        return this;
    }

    public ResultBuilder setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
        return this;
    }

    public ResultBuilder setResultMsg(ResultMsg resultMsg) {
        this.resultMsg = resultMsg;
        return this;
    }

    public ResultBuilder setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
}
