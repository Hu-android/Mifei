package com.example.administrator.mifei.bean;

import java.util.List;

/**
 * Created by 123 on 2018/5/25.
 */

public class LoginBean {
    private int code;
    private String message;
    private UserBean data;

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

    public UserBean getData() {
        return data;
    }

    public void setData(UserBean data) {
        this.data = data;
    }
}
