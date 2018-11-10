package com.baiwang.admin.portal.common.aop;

import com.baiwang.admin.portal.common.exception.BopException;
import com.baiwang.moirai.utils.JacksonUtil;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * AOP 切 log
 */
@Aspect
@Component
public class LogAspect {

    private static Logger log = LoggerFactory.getLogger(LogAspect.class);

    /**
     * 监控控制层API请求
     */
    //@Pointcut("execution(public * com.baiwang.bop.*.*(..))")
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void log() {
    }

    /**
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Around("log()")
    public Object around(ProceedingJoinPoint invocation) throws Throwable {
        long beginTime = System.currentTimeMillis();
        Signature signature = invocation.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        String[] names = methodSignature.getParameterNames();
        Object[] args = invocation.getArgs();
        String requestId = "";
        int position = -1;
        for (int i = 0; i < names.length; i++) {
            if ("requestId".equals(names[i])) {
                requestId = (String) args[i];
                position = i;
                break;
            }
        }
        if (position >= 0 && StringUtils.isEmpty(requestId)) {
            requestId = UUID.randomUUID().toString();
            args[position] = requestId;
        }

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Object result;
        try {
            log.info("[bop] requestId={}, url={}", requestId, request.getRequestURL());
            result = invocation.proceed(args);
            log.info("[bop] requestId={}, return result={} ", requestId, JacksonUtil.beanToString(result));
        } catch (Throwable e){
            String msg = e.getMessage();
            if (e instanceof BopException) {
                msg = ((BopException) e).getErrorMsg();
            }
            //log.info("[bop] requestId={}, request occur exception={} ", requestId, msg);
            throw e;
        } finally {
            log.info("[bop] requestId={}, duration={} ms", requestId, (System.currentTimeMillis() - beginTime));
        }
        return result;
    }

}
