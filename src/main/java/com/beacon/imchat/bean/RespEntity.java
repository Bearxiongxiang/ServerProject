package com.beacon.imchat.bean;

/**
 * Created by F1331886 on 2018/1/18 0018.
 * 反馈信息
 */
public class RespEntity {
    private int code;
    private String msg;
    private Object data;

    public RespEntity(RespCode respCode) {
        this.code = respCode.getCode();
        this.msg = respCode.getMsg();
    }

    public RespEntity(RespCode respCode, Object data) {
        this(respCode);
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
