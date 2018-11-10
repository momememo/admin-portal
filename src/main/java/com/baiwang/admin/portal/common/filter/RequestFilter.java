package com.baiwang.admin.portal.common.filter;

import com.baiwang.admin.portal.bean.result.Result;
import com.baiwang.admin.portal.service.LoginService;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @Description:
 * @author: liyunfei
 * @date: 2018/9/3 11:10
 */
public class RequestFilter implements Filter {

    private LoginService loginService;

    String THE_CONTENT_TYPE = "text/json; charset=utf-8";

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        Result result = loginService.checkLogin(request, response);
        if (result.isSuccess()) {
            chain.doFilter(request, response);
        } else {
            response.setContentType(THE_CONTENT_TYPE);
            response.getWriter().write("会话失效，请重新登录！");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {
        ServletContext sc = filterConfig.getServletContext();
        WebApplicationContext cxt = WebApplicationContextUtils.getWebApplicationContext(sc);

        if (cxt != null && cxt.getBean(LoginService.class) != null && loginService == null) {
            loginService = cxt.getBean(LoginService.class);
        }

    }

    @Override
    public void destroy() {

    }
}
