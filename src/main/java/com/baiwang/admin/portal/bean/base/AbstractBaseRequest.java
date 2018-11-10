package com.baiwang.admin.portal.bean.base;

import java.io.Serializable;

/**
 * @Description:
 * @author: liyunfei
 * @date: 2018/8/28 22:01
 */
abstract class AbstractBaseRequest implements Serializable {

    private String requestId;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
