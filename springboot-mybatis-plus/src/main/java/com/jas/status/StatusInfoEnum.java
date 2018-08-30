package com.jas.status;

/**
 * @author zc
 * @description
 * @create 2018-08-21 17:58
 */
public enum StatusInfoEnum {
    REQUEST_SUCCESS("200", "OK"),
    BUSINESS_FAILURE("500", "服务器忙，请稍后再次尝试，或者跟管理员联系");

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
