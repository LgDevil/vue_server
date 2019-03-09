package com.auxing.vue_server.utils;

public class BlogResult {

    private  Integer code = 0;

    private Object data;

    private String message;

    public Integer getCode() {
        return code;
    }


    public static BlogResult getInstance(){
        return  new BlogResult();
    }

    public void setCode(Integer code) {
        this.code = code;
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
}
