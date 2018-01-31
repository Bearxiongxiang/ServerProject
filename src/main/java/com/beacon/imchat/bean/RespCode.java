package com.beacon.imchat.bean;

/**
 * Created by F1331886 on 2018/1/19 0019.
 */
public enum RespCode {
    SUCCESS(0, "请求成功"),

    WARN(-1, "网络异常，请稍后重试");

    private int code;
    private String msg;

    RespCode(int code, String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}