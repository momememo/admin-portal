package com.baiwang.admin.portal.bean.base;

import java.io.Serializable;

/**
 * @Description:
 * @author: liyunfei
 * @date: 2018/8/29 9:34
 */
abstract class AbstractBaseResponse implements Serializable {

    private String requestId;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
