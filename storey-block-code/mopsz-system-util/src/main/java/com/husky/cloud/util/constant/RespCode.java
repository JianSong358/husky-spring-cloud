package com.husky.cloud.util.constant;

public enum RespCode {

    LOGIN_ERROR ("5010","用户名或密码错误"),
    PARAM_ERROR ("5012","请求参数错误"),
    FEIGN_ERROR ("5013","服务超时,请重试");

    private String code;
    private String msg;

    RespCode (String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
