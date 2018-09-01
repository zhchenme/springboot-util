package com.jas.bean;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 封装线段、柱状图数据
 * </p>
 *
 * @author zchen
 * @create 2018-08-31
 */
public class LineAndBarChartBean implements Serializable {
	private static final long serialVersionUID = 1L;

    /**
     * 数据类型维度 比如：已完成与未完成维度
     */
	private String name;

	/**
	 * 显示类型（线段、柱状图、饼图）
	 */
	private String type;

    /**
     * 是否平滑显示
     */
	private boolean smooth = true;

    /**
     * 返回的数据
     */
	private List<?> data;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isSmooth() {
		return smooth;
	}

	public void setSmooth(boolean smooth) {
		this.smooth = smooth;
	}

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaiduSeries{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", smooth=" + smooth +
                ", data=" + data +
                '}';
    }
}
