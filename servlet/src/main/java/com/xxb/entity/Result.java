package com.xxb.entity;

public class Result {

    private String message;
    private boolean success;
    private Object data;
    private int code;



    public Result(boolean success, String message, Object data) {
        this.message = message;
        this.success = success;
        this.data = data;
    }

    public Result(boolean success, String message) {
        this.message = message;
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
