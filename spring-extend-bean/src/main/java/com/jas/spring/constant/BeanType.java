package com.jas.spring.constant;
/**
 * BeanType
 *
 * @author lanxiang
 * @since 2019-08-01
 */
public enum BeanType {

    CLASS_A("业务1", "CLASS_A"),
    CLASS_B("业务2", "CLASS_B");

    private String desc;
    private String beanType;

    BeanType(String desc, String beanType) {
        this.desc = desc;
        this.beanType = beanType;
    }

    public String getDesc() {
        return desc;
    }

    public String getBeanType() {
        return beanType;
    }
}
