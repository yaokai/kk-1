package com.kk.user.bean;

import java.io.Serializable;

public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

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

    int code;
    String message;



}
