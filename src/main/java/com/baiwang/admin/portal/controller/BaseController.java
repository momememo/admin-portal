package com.baiwang.admin.portal.controller;

import com.baiwang.admin.portal.bean.result.Result;
import com.baiwang.admin.portal.bean.result.ResultBuilder;

/**
 * @Description:
 * @author: liyunfei
 * @date: 2018/9/4 9:24
 */
public class BaseController {

    protected Result convertResult(String requestId, Object model) {
        return ResultBuilder.newResult()
                .setIsSuccess(true)
                .setModel(model)
                .setRequestId(requestId)
                .build();
    }

}
