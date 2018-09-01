package com.jas.util;


import com.jas.bean.ChartDataBean;
import com.jas.bean.LineAndBarChartBean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * <p>
 * Chart 处理工具类
 * </p>
 *
 * @author zchen
 * @create 2018-08-31
 */
public class ChartUtil {
    /**
     * 线图、柱状图返回的数据集合
     */
	List<LineAndBarChartBean> lineAndBarChartBeanList;

    /**
     * 横坐标，比如：月份
     */
	private List<String> xaxis;

    /**
     * Chart 主标题
     */
	private String title;

    /**
     * Chart 子标题
     */
	private String subTitle;

    /**
     * Chart 返回数据
     */
	private ChartDataBean charData;

	public ChartUtil() {
		this.lineAndBarChartBeanList = new ArrayList<>();
		charData = new ChartDataBean();
	}

    /**
     * 构造返回的数据
     * 
     * @return
     */
	public ChartDataBean getData() {
		charData.setTitle(title);
        charData.setSubTitle(subTitle); 
		charData.setLineAndBarChartBeanList(lineAndBarChartBeanList);
		charData.setXaxis(xaxis);

		return charData;
	}
    
	public void addLine(String name, List<?> data) {
		addData(name, "line", data);
	}

	public void addBar(String name, List<?> data) {
		addData(name, "bar", data);
	}

    /**
     * 设置饼图数据
     * 
     * @param name
     * @param data
     */
    public void addPie(String name, LinkedHashMap<String, BigDecimal> data) {
        charData.setPromptMessage(name);
        charData.setData(data);
    }
	
	/**
	 * 设置 Chart（线图、柱状图） 数据类型维度、显示类型、真实数据
     * 
	 * @param name
	 * @param chartType bar，line，K（此时data是一个是个浮点数的数组）
	 * @param data
	 */
	private void addData(String name, String chartType, List<?> data) {
		LineAndBarChartBean s = new LineAndBarChartBean();

		s.setName(name);
		s.setType(chartType);
		s.setData(data);

		this.lineAndBarChartBeanList.add(s);
	}

    /**
     * 设置横坐标
     * 
     * @param xAxis
     */
	public void setXData(List<String> xAxis) {
		this.xaxis = xAxis;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

}
