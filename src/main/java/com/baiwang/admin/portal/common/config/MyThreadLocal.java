package com.baiwang.admin.portal.common.config;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: threadlocal 工具类
 * @author: liyunfei
 * @date: 2018/11/10 11:14
 */
public class MyThreadLocal {

    private static final ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();

    public static void setProperty(String key, Object value) {
        Map<String, Object> map = threadLocal.get();
        if (null == map) {
            map = new HashMap<>();
        }
        map.put(key, value);
        threadLocal.set(map);
    }

    public static Object getProperty(String key) {
        Map<String, Object> map = threadLocal.get();
        if (map != null) {
            return map.get(key);
        }
        return null;
    }

    public static void remove(String key) {
        Map<String, Object> map = threadLocal.get();
        if (map != null) {
            map.remove(key);
            if (map.size() == 0) {
                threadLocal.remove();
            }
        }
    }

    public static void removeAll() {
        threadLocal.remove();
    }
}
