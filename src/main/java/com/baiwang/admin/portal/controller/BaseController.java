package com.baiwang.admin.portal.controller;

import com.baiwang.admin.portal.bean.result.Result;
import com.baiwang.admin.portal.bean.result.ResultBuilder;
import com.baiwang.admin.portal.common.exception.BindingError;
import com.baiwang.admin.portal.common.exception.BopErrorEnum;
import com.baiwang.admin.portal.common.exception.BopException;
import com.baiwang.moirai.utils.JacksonUtil;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

/**
 * @Description:
 * @author: liyunfei
 * @date: 2018/9/4 9:24
 */
public class BaseController {


    protected void validateBindingResult(BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            List<BindingError> errors = new ArrayList<>();
            allErrors.stream().forEach(error -> {
                String field = error.getObjectName();
                String message = error.getDefaultMessage();
                errors.add(new BindingError(field, message));
            });
            throw new BopException(BopErrorEnum.BOP_INVALID_PARAM, errors);
        }
    }

    protected Result convertResult(String requestId, Object model) {
        return ResultBuilder.newResult()
                .setIsSuccess(true)
                .setModel(model)
                .setRequestId(requestId)
                .build();
    }


}
