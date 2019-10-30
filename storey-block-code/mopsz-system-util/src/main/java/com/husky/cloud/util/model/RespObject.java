package com.husky.cloud.util.model;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class RespObject extends HashMap<String, Object> implements Serializable {
    private static final long serialVersionUID = 1L;

    public RespObject () {
        put("code", 200);
        put("msg", "success");
    }

    public RespObject (String code,String msg) {
        put("code", code);
        put("msg", msg);
    }

    public static RespObject error () {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "系统异常");
    }

    public static RespObject error (String msg) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
    }

    public static RespObject error(int code, String msg) {
        RespObject respObject = new RespObject();
        respObject.put("code", code);
        respObject.put("msg", msg);
        return respObject;
    }

    public static RespObject ok(String msg) {
        RespObject respObject = new RespObject();
        respObject.put("msg", msg);
        return respObject;
    }

    public static RespObject ok(Map<String, Object> map) {
        RespObject respObject = new RespObject();
        respObject.putAll(map);
        return respObject;
    }

    public static RespObject ok() {
        return new RespObject();
    }

    public RespObject put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
