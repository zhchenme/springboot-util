package com.jas.bean;

/**
 * <p>
 * 封装饼图数据
 * </p>
 *
 * @author zchen
 * @create 2018-08-31
 */
public class PieChartEntryBean {
    /**
     * 数据
     */
	private Object value;

	/**
	 * 数据类型维度
	 */
	private String name;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BaiduEntry{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}
