package com.baiwang.admin.portal.common.exception;

import com.baiwang.admin.portal.bean.result.Result;
import com.baiwang.admin.portal.bean.result.ResultBuilder;
import com.baiwang.admin.portal.bean.result.ResultMsg;
import com.baiwang.admin.portal.common.util.RequestUtil;
import com.baiwang.moirai.utils.JacksonUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description:
 * @author: liyunfei
 * @date: 2018/8/29 16:17
 */
@ControllerAdvice
public class BopExceptionHandler {

    private static Logger log = LoggerFactory.getLogger(BopExceptionHandler.class);


    @ResponseBody
    @ExceptionHandler(BopException.class)
    public Result handleBopException(BopException e) {

        String requestId = RequestUtil.getRequestId();
        Exception cause = e.getCause();
        String code = null;
        Object model = null;
        String message;

        if (e.getData() != null) {
            model = e.getData();
        }

        message = e.getMessage() == null ? "" : e.getMessage();
        if (e.getErrorEnum() != null) {
            code = e.getErrorEnum().getCode();
            message = e.getErrorEnum().getMsg() + "！" + message;
        }

        StringBuffer msg = new StringBuffer(requestId);
        msg.append(" --> BopException:");
        if (!StringUtils.isEmpty(code)) {
            msg.append(" errorCode: ").append(code);
        }
        if (!StringUtils.isEmpty(message)) {
            msg.append(" errorMsg: ").append(message);
        }
        if (model != null) {
            msg.append(" errorData:").append(JacksonUtil.beanToString(model));
        }

        // 输出错误日志
        if (cause != null) {
            log.error(msg.toString(), cause);
        } else if (model != null) {
            log.error(msg.toString());
        } else {
            log.error(msg.toString(), e);
        }

        // 返回错误结果
        Result result = ResultBuilder.newResult()
                .setRequestId(requestId)
                .setIsSuccess(false)
                .setResultMsg(new ResultMsg(code, message))
                .setModel(model)
                .build();

        RequestUtil.removeRequestId();
        return result;
    }


    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        String requestId = RequestUtil.getRequestId();
        String message = e.getMessage();
        StringBuffer msg = new StringBuffer(requestId);
        msg.append(" --> BopException: ");
        if (!StringUtils.isEmpty(message)) {
            msg.append("errorMsg: ").append(message);
        }
        // 输出错误日志
        log.error(msg.toString(), e);
        // 返回错误结果
        Result result = ResultBuilder.newResult()
                .setRequestId(requestId)
                .setIsSuccess(false)
                .setResultMsg(new ResultMsg("500", message))
                .build();
        RequestUtil.removeRequestId();
        model.addAttribute("", result);
        return "error";
    }
}
