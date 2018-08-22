package com.jas.status;

/**
 * @author zc
 * @description 逻辑删标识
 * @create 2018-08-21 17:50
 */
public enum BaseLogicDeleteEnum {
	/**
	 * 逻辑删除
	 */
	LogicDelete("删除","1"),
	/**
	 * 未删除
	 */
	LogicNotDelete("未删除","0");
	
    private String name;

    private String value;
	
    BaseLogicDeleteEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
