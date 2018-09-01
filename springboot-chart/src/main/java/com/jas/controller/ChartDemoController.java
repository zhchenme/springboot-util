package com.jas.controller;

import com.jas.bean.ChartDataBean;
import com.jas.util.ChartUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

/**
 * <p>
 * Chart 控制器
 * </p>
 *
 * @author zchen
 * @create 2018-08-31
 */
@RestController
@RequestMapping(value = "/chart")
public class ChartDemoController {
    /**
     * 模拟 6 个月份
     */
	private static final int DATA_COUNT = 6;

    /**
     * 曲线图数据测试
     * 
     * @return
     */
	@RequestMapping("/line")
	public ChartDataBean line() {
		ChartUtil util = new ChartUtil();

		util.setTitle("简单的线图");
		util.setSubTitle("线图子标题");
		// 设置 X 轴坐标
		util.setXData(getXAxis(DATA_COUNT));
		// 数据
		util.addLine("线段1", createData(DATA_COUNT));
		util.addLine("线段2", createData(DATA_COUNT));

		return util.getData();
	}

    /**
     * 柱状图数据测试
     * 
     * @return
     */
	@RequestMapping("/bar")
	public ChartDataBean bar() {
		ChartUtil util = new ChartUtil();

		util.setTitle("简单的柱图");
		util.setSubTitle("子标题");
        // 设置 X 轴坐标
		util.setXData(getXAxis(DATA_COUNT));
		// 数据
		util.addBar("柱1", createData(DATA_COUNT));
		util.addBar("柱2", createData(DATA_COUNT));

		return util.getData();
	}

    /**
     * 曲线图与柱状图测试
     * 
     * @return
     */
	@RequestMapping("/lineAndBar")
	public ChartDataBean lineAndBar() {
		ChartUtil util = new ChartUtil();

		util.setTitle("简单的线图和柱图");
		util.setSubTitle("子标题");
        // 设置 X 轴坐标
		util.setXData(getXAxis(DATA_COUNT));
		// 数据
		util.addLine("线段1", createData(DATA_COUNT));
		util.addBar("柱1", createData(DATA_COUNT));

		return util.getData();
	}

    /**
     * 饼图测试
     * 
     * @return
     */
	@RequestMapping("/pie")
	public ChartDataBean pie() {
		ChartUtil util = new ChartUtil();

		util.setTitle("饼图例子");
		// 数据
		util.addPie("提示文字", createMapData(5));

		return util.getData();
	}

    /**
     * 模拟真实数据
     * 
     * @param count
     * @return
     */
	private List<Integer> createData(int count) {
		List<Integer> data = new ArrayList<>();

		for (int j = 0; j < count; j++) {
			data.add(new Random().nextInt());
		}
		return data;
	}

    /**
     * 模拟横坐标数据：月份
     * 
     * @param count
     * @return
     */
	private List<String> getXAxis(int count) {
		List<String> list = new ArrayList<>();
		for (int j = 1; j <= count; j++) {
			list.add(j + "月");
		}

		return list;
	}

	/**
	 * 构建饼图的数据
	 * 
	 * @param count
	 * @return
	 */
	private LinkedHashMap<String, BigDecimal> createMapData(int count) {
		LinkedHashMap<String, BigDecimal> result = new LinkedHashMap<>(count);

		for (int j = 1; j <= count; j++) {
			result.put(j + "月", new BigDecimal(new Random().nextFloat()));
		}

		return result;
	}
}
