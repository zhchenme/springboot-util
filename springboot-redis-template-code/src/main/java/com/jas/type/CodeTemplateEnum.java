package com.jas.type;

/**
 * <p>
 * 编码枚举
 * </p>
 * 
 * @author zchen
 * @create 2018-09-25 15:23
 */
public enum CodeTemplateEnum {

    /**
     * 测试
     */
    CODE_TEST("测试编码", "testCode");
    
    private String name;

    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    CodeTemplateEnum(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
