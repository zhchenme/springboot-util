package com.jas.status;

/**
 * @author zc
 * @description
 * @create 2018-08-21 17:58
 */
public enum StatusInfoEnum {
    REQUEST_SUCCESS("200", "OK");

    /**
     * 状态码
     */
    private final String code;
    
    /**
     * 原因短语
     */
    private final String message;

    StatusInfoEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
