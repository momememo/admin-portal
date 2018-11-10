package com.baiwang.admin.portal.common.util;

import com.baiwang.admin.portal.common.config.MyThreadLocal;
import com.baiwang.admin.portal.common.constant.Constant;
import java.util.UUID;

/**
 * @Description:
 * @author: liyunfei
 * @date: 2018/11/10 11:17
 */
public class RequestUtil {

    public static String getRequestId() {
        Object o = MyThreadLocal.getProperty(Constant.REQUEST_ID);
        if (o == null) {
            String requestId = UUID.randomUUID().toString();
            MyThreadLocal.setProperty(Constant.REQUEST_ID, requestId);
            return requestId;
        }
        return o.toString();
    }

    public static void removeRequestId() {
        MyThreadLocal.remove(Constant.REQUEST_ID);
    }
}
