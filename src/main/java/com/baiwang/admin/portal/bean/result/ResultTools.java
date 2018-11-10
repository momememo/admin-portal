package com.baiwang.admin.portal.bean.result;

import com.alibaba.fastjson.JSONObject;
import java.util.List;
import org.apache.commons.lang.StringUtils;

public class ResultTools<T> {

    private ResultTools() {
    }

    public static <T> Result<T> ToArrayResult(String json, Class<List> t) {
        return (Result<T>) convertResult(json, t);
    }

    public static <T> Result<T> ToResult(String json, Class<T> t) {
        return (Result<T>) convertResult(json, t);
    }

    public static <T> Result<?> convertResult(String json, Class<?> t) {
        JSONObject jsonObject = JSONObject.parseObject(json);
        String modelJson = jsonObject.getString("model");
        String requestId = jsonObject.getString("requestId");
        Boolean success = jsonObject.getBoolean("success");
        String messageJson = jsonObject.getString("message");

        ResultMsg resultMsg = null;
        if (StringUtils.isBlank(modelJson) && success) {
            JSONObject modelMsgObject = JSONObject.parseObject(messageJson);
            JSONObject o = new JSONObject();
            o.put("message", modelMsgObject.get("successMessage"));
            modelJson = o.toJSONString();
            t = JSONObject.class;
        } else {
            resultMsg = JSONObject.parseObject(messageJson, ResultMsg.class);
        }
        T value = (T) JSONObject.parseObject(modelJson, t);
        Result<T> rpic = new Result<T>(value, success, resultMsg, requestId);
        return rpic;
    }

    public static <T> Result<?> convertResultForReport(String json, String requestId, Class<?> t) {
        JSONObject jsonObject = JSONObject.parseObject(json);
        Boolean success = jsonObject.getBoolean("success");
        String returnCode = jsonObject.getString("returnCode");
        String returnMessage = jsonObject.getString("returnMessage");
        String data = jsonObject.getString("data");

        ResultMsg resultMsg = null;
        T value = null;
        if(!success){
            resultMsg = new ResultMsg(returnCode,returnMessage);
        }else{
            resultMsg = new ResultMsg(returnMessage);
            value = (T) JSONObject.parseObject(data, t);
        }
        Result<T> rpic = new Result<T>(value, success, resultMsg, requestId);
        return rpic;
    }

}