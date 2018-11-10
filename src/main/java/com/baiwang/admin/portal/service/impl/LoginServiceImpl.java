package com.baiwang.admin.portal.service.impl;

import com.baiwang.admin.portal.bean.entity.User;
import com.baiwang.admin.portal.bean.result.Result;
import com.baiwang.admin.portal.bean.result.ResultBuilder;
import com.baiwang.admin.portal.common.constant.Constant;
import com.baiwang.admin.portal.common.exception.BopErrorEnum;
import com.baiwang.admin.portal.common.exception.BopException;
import com.baiwang.admin.portal.common.util.MD5Util;
import com.baiwang.admin.portal.common.util.RequestUtil;
import com.baiwang.admin.portal.mapper.UserMapper;
import com.baiwang.admin.portal.service.LoginService;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @author: liyunfei
 * @date: 2018/9/3 16:12
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserMapper userMapper;

    private static Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);

    /**
     * 用户登录
     *
     * @param user
     * @param request
     * @param response
     */
    @Override
    public Result login(User user, HttpServletRequest request, HttpServletResponse response) {
        String requestId = RequestUtil.getRequestId();
        ResultBuilder builder = ResultBuilder.newResult().setRequestId(requestId);
        // 验证登录
        String loginName = user.getLoginName();
        User dbUser = userMapper.selectUserByLoginName(loginName);
        String encrypt = MD5Util.encrypt(user.getLoginPassword());
        if (dbUser == null || !encrypt.equals(dbUser.getLoginPassword())) {
            throw new BopException(requestId, BopErrorEnum.BOP_INCORRECT_LOGIN_INFO);
        }
        // 保存登录信息
        request.getSession().setAttribute(Constant.SESSION_USER, dbUser);
        Cookie cookie = getCookie(request, Constant.JSESSIONID);
        String jsessionId = null;
        if (cookie != null) {
            jsessionId = cookie.getValue();
        }
        if (StringUtils.isNotBlank(jsessionId)) {
            redisTemplate.opsForValue().set(jsessionId, loginName, 30, TimeUnit.MINUTES);
        }
        return builder.setModel(dbUser).buildSuccess();

    }

    /**
     * 校验用户是否登录
     *
     * @param request
     * @param response
     */
    @Override
    public void checkLogin(HttpServletRequest request, HttpServletResponse response) {

        String jsessionId = null;
        Cookie cookie = getCookie(request, Constant.JSESSIONID);
        if (cookie != null) {
            jsessionId = cookie.getValue();
        }
        if (jsessionId == null) {
            throw new BopException(BopErrorEnum.BOP_INCORRECT_JESSIONID);
        }

        Object o = redisTemplate.opsForValue().get(jsessionId);
        if (o == null) {
            throw new BopException(BopErrorEnum.BOP_ERROR_SESSION_EXPIRED);
        }
        User user = (User) request.getSession().getAttribute(Constant.USER);
        if (user == null) {
            throw new BopException(BopErrorEnum.BOP_ERROR_SESSION_EXPIRED);
        }
        String loginName = user.getLoginName();
        redisTemplate.opsForValue().set(jsessionId, loginName, 30, TimeUnit.MINUTES);
        request.removeAttribute(Constant.USER);
        request.setAttribute(Constant.USER, user);
    }


    private Cookie getCookie(HttpServletRequest request, String cookieKey) {
        Cookie cookie = null;
        List<Cookie> cookies = Arrays.asList(request.getCookies());
        Optional<Cookie> first = cookies
                .stream()
                .filter(c -> cookieKey.equalsIgnoreCase(c.getName()))
                .findFirst();
        if (first.isPresent()) {
            cookie = first.get();
        }
        return cookie;
    }


}
