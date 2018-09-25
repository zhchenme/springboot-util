package com.jas.util;

import cn.hutool.core.date.DateUtil;

/**
 * <p>
 * 随机数工具类
 * </p>
 *
 * @author zchen
 * @create 2018-09-25 15:32
 */
public class RandomUtil {

    /**
     * 为编码生成随机数
     *
     * @return
     */
    public static Long getRandomNum4TemplateCode() {
        // 初始值
        final String ORIGINAL_VALUE = "00000";
        // 当前时间
        String format = DateUtil.format(DateUtil.date(), "yyyyMMdd");

        return new Long(format + (int) ((Math.random() * 9 + 1) * 100000) + ORIGINAL_VALUE);
    }

    /**
     * 生成 6 位随机数
     *
     * @return
     */
    public static Integer getRandomCode() {
        return (int) ((Math.random() * 9 + 1) * 100000);
    }


    /**
     * 生成12位随机数
     *
     * @return
     */
    public static String getTXMcode() {
        double v = ((Math.random() * 9 + 1) * 100000000000.0);
        Long v2 = (long) v;

        return v2.toString();
    }
}
