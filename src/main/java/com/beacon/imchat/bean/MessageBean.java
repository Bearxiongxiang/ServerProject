package com.beacon.imchat.bean;

/**
 * 状态码封装基类
 *
 * @author Bear
 * @version V1.0
 * @date Apr 19, 2017 8:56:35 AM
 */
public class MessageBean {

    private int code;
    private Object message;
    private Object data;

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

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageBean{" +
                "code=" + code +
                ", message=" + message +
                ", data=" + data +
                '}';
    }
}


