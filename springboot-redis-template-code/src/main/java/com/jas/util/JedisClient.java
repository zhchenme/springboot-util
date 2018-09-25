package com.jas.util;

/**
 * <p>
 * Redis 工具类接口
 * </p>
 * 
 * @author zchen
 * @create 2018-09-25 15:38
 */
public interface JedisClient {
    /**
     * 设置key value
     *
     * @param key
     * @param value
     * @return
     */
    String set(String key, String value);

    /**
     * 获取
     *
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 判断key是否存在
     *
     * @param key
     * @return
     */
    Boolean exists(String key);

    /**
     * 自增
     * 
     * @param key
     * @return
     */
    Long incr(String key);
}
