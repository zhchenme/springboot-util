package com.jas.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 * <p>
 * 封装 Chart 返回数据（所有类型的图表）
 * </p>
 *
 * @author zchen
 * @create 2018-08-31
 */
public class ChartDataBean {
    /**
     * 数据类型维度集合
     */
	private List<String> legend;

	/**
	 * 横坐标，比如：月份
	 */
	private List<String> xaxis;

    /**
     * 线图、柱状图返回的数据集合
     */
	private List<LineAndBarChartBean> lineAndBarChartBeanList;

    /**
     * 饼图返回的数据集合
     */
	private List<PieChartEntryBean> pieChartEntryBeanList;

    /**
     * Chart 主标题
     */
	private String title;

    /**
     * Chart 子标题
     */
	private String subTitle;

    /**
     * 字符串类型的提示信息
     */
	private String promptMessage;

	public List<LineAndBarChartBean> getLineAndBarChartBeanList() {
		return lineAndBarChartBeanList;
	}

	public void setLineAndBarChartBeanList(List<LineAndBarChartBean> lineAndBarChartBeanList) {
		this.lineAndBarChartBeanList = lineAndBarChartBeanList;

		// 将数据栏次信息填充到栏次集合中
		if (!lineAndBarChartBeanList.isEmpty()) {
			this.legend = extractLegend();
		}
	}

	public ChartDataBean() {
		super();
	}

    /**
     * 获取数据类型维度集合
     * 
     * @return
     */
	private List<String> extractLegend() {
		List<String> list = new ArrayList<>();

		for (LineAndBarChartBean bean : lineAndBarChartBeanList) {
			list.add(bean.getName());
		}

		return list;
	}

	public List<String> getLegend() {
		return legend;
	}

	public void setLegend(List<String> legend) {
		this.legend = legend;
	}

	public List<String> getXaxis() {
		return xaxis;
	}

	public void setXaxis(List<String> xaxis) {
		this.xaxis = xaxis;
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

	/**
     * 设置饼图数据
	 * 
	 * @param data
	 */
	public void setData(LinkedHashMap<String, BigDecimal> data) {
		setPieChartEntryBeanList(map2Entry(data));
		// 设置饼图数据类型维度集合
		this.legend = new ArrayList<>(data.keySet());
	}

    /**
     * 将 map 转换成饼图数据类型
     * 
     * @param data
     * @return
     */
	private List<PieChartEntryBean> map2Entry(LinkedHashMap<String, BigDecimal> data) {
		List<PieChartEntryBean> list = new ArrayList<>();

		Iterator<Entry<String, BigDecimal>> iterator = data.entrySet().iterator();

		while (iterator.hasNext()) {
			Entry<String, BigDecimal> entry = iterator.next();
			PieChartEntryBean e = new PieChartEntryBean();

			e.setName(entry.getKey());
			e.setValue(entry.getValue());

			list.add(e);
		}

		return list;
	}

	public List<PieChartEntryBean> getPieChartEntryBeanList() {
		return pieChartEntryBeanList;
	}

	public void setPieChartEntryBeanList(List<PieChartEntryBean> entry) {
		this.pieChartEntryBeanList = entry;
	}

    public String getPromptMessage() {
        return promptMessage;
    }

    public void setPromptMessage(String promptMessage) {
        this.promptMessage = promptMessage;
    }
}
