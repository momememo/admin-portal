package com.baiwang.admin.portal.common.util;

import com.baiwang.admin.portal.bean.entity.User;
import com.baiwang.admin.portal.common.constant.Constant;
import com.baiwang.admin.portal.common.exception.BopException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 开放平台Session统一管理类
 *
 * @author wwm
 * @ClassName: WebSessionUtils
 * @date 2016年6月28日 下午8:04:52
 */
public class WebSessionUtils {


    /**
     * 从session中获取用户信息
     */
    public static User getUserInfo() {
        User user;
        try {
            user = (User) getRequest().getSession().getAttribute(Constant.USER);
        } catch (BopException e) {
            user = null;
        }
        return user;
    }

    /**
     * session赋值
     *
     * @param key   sessionKey值
     * @param value sessionValue值
     */
    public static void setAttribute(String key, Object value) {
        getRequest().getSession().setAttribute(key, value);
    }

    /**
     * session取值
     *
     * @param key sessionKey值
     * @return 数据
     */
    public static Object getAttribute(String key) {
        return getRequest().getSession().getAttribute(key);
    }


    /**
     * 清空session属性
     *
     * @param key sessionKey值
     */
    public void removeAttribute(String key) {
        getRequest().getSession().removeAttribute(key);
    }

    /**
     * 获取 HttpServletRequest
     *
     * @return HttpServletRequest
     */
    public static HttpServletRequest getRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;
        return attributes.getRequest();
    }

}
