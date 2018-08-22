
package com.jas.common;

import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

/**
 * @author zc
 * @description 分页请求
 * @create 2018-08-21 17:58
 */
public class MyBasePageRequest<T> {
    /**
     * 默认每页数据条数
     */
    private int size = 10;

    /**
     * 当前页
     */
    private int current = 1;

    /**
     * 排序（ASC）集合
     */
    private List<String> ascs;

    /**
     * 排序（DESC）集合
     */
    private List<String> descs;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
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

    private Page<T> mypagePlus;

    /**
     * 获取 mybatis Plus 封装的 Page 对象
     *
     * @return
     */
    public Page<T> getPagePlus() {
        // 懒加载
        if (mypagePlus == null) {
            mypagePlus = new Page<>();
        }

        mypagePlus.setCurrent(this.current);
        mypagePlus.setSize(this.size);
        mypagePlus.setAscs(ascs);
        mypagePlus.setDescs(descs);

        return mypagePlus;
    }

}
