package com.baiwang.admin.portal.common.util;

import com.baiwang.admin.portal.common.config.MyThreadLocal;
import com.baiwang.admin.portal.common.constant.Constant;
import com.baiwang.admin.portal.common.exception.BindingError;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.apache.commons.lang.StringUtils;

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

    public static List<BindingError> customBindingError(String field, String message) {

        if (StringUtils.isBlank(field)) {
            return null;
        }
        if (StringUtils.isBlank(message)) {
            message = "";
        }
        List<BindingError> errors = new ArrayList<>();
        errors.add(new BindingError(field, message));
        return errors;
    }
}
