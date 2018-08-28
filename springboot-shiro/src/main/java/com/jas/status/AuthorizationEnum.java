package com.jas.status;

/**
 * <p>
 * 用户权限枚举
 * </p>
 * 
 * @author zchen
 * @create 2018-08-28 14:34
 */
public enum AuthorizationEnum {
    /**
     * 管理员
     */
    MANAGER_ALL("all", "管理员具有所有权限"),
    /**
     * 普通用户
     */
    USER_SELECT("select", "普通用户只具有查看权限");

    /**
     * 权限码
     */
    private String code;

    /**
     * 原因短语
     */
    private String message;
    
    AuthorizationEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
