/*
 * @项目名称: Moirai
 * @文件名称: BopErrorEnum.java
 * @Date: 17-12-25 下午6:41
 * @author Lance cui
 *
 */

package com.baiwang.admin.portal.common.exception;

import org.springframework.util.StringUtils;

public enum BopErrorEnum {

    BOP_UNKNOWN_ERROR("60", "未知系统异常"),
    BOP_APPSERVICE_ERROR("1001", "访问APP服务异常"),
    BOP_MISSING_PARAM("100000", "缺少参数"),
    BOP_INVALID_PARAM("100001", "参数取值范围错误"),
    BOP_INVALID_TOKEN("100002", "token错误"),
    BOP_BAD_APP_KEY("100003", "appKey错误或无访问权限"),
    BOP_BLACK_LIST("100004", "黑名单用户"),
    BOP_TOO_FREQUENT_REQUEST("100005", "请求频繁"),
    BOP_REMOTE_SERVICE_ERROR("100006", "远程访问错误"),
    BOP_BAD_SIGN("100007", "签名无效"),
    BOP_INTERNAL_ERROR("100008", "系统内部错误"),
    BOP_INTERNAL_MAX_LIMIT("100009", "超过系统最大容流量"),
    BOP_ERROR_INNER_TIMEOUT("100010", "系统超时"),
    BOP_ERROR_SESSION_EXPIRED("100011", "会话已过期，请重新登录"),
    BOP_ERROR_TOKEN_UNDETECTED("100012", "没有检测到token，请先获取token"),
    BOP_INCORRECT_LOGIN_INFO("100013", "用户名密码错误"),
    BOP_INCORRECT_JESSIONID("100014", "没有找到JSESSIONID"),
    BOP_DUPLICATE_METHOD_NAME("100015", "重复的method名称"),
    BOP_LOGIN_NAME_REGISTERED("100016", "该用户登录账号已经被注册");

    private String msg;
    private String code;

    public static BopErrorEnum getByCode(String code) {
        if (StringUtils.isEmpty(code)) {
            return null;
        } else {
            BopErrorEnum[] var1 = values();
            int var2 = var1.length;

            for (int var3 = 0; var3 < var2; ++var3) {
                BopErrorEnum errorEnum = var1[var3];
                if (errorEnum.getCode().equals(code)) {
                    return errorEnum;
                }
            }

            return null;
        }
    }

    private BopErrorEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getCode() {
        return this.code;
    }
}
