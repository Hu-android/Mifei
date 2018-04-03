package com.example.administrator.mifei.bean;

/**
 * Created by Administrator on 2018/4/3 0003.
 */

public class BaseResponse {
    private int code;  //请求结果状态 1 成功  -1失败
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
