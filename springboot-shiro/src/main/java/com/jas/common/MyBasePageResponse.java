package com.jas.common;

import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

/**
 * @author zc
 * @description 分页响应
 * @create 2018-08-24 17:58
 */
public class MyBasePageResponse<T> {
    /**
     * 总记录数
     */
	private Long total;

    /**
     * 每页显示条数
     */
	private int size;

    /**
     * 总页数
     */
	private Long pages;

    /**
     * 当前页
     */
	private int current;

	/**
	 * 查询数据列表
	 */
	private List<T> records;

    /**
     * 排序（ASC）集合
     */
	private List<String> ascs;

    /**
     * 排序（DESC）集合
     */
    private List<String> descs;
	
	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Long getPages() {
		return pages;
	}

	public void setPages(Long pages) {
		this.pages = pages;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}

    public List<String> getAscs() {
        return ascs;
    }

    public void setAscs(List<String> ascs) {
        this.ascs = ascs;
    }

    public List<String> getDescs() {
        return descs;
    }

    public void setDescs(List<String> descs) {
        this.descs = descs;
    }

    public MyBasePageResponse() {
	}

	public MyBasePageResponse(Page<T> page) {
		this.current = page.getCurrent();
		this.size = page.getSize();
		this.total = page.getTotal();
		this.records = page.getRecords();
		this.pages = page.getPages();
		this.ascs = page.getAscs();
		this.descs = page.getDescs();
	}
}
