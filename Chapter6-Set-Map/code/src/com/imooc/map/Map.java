package com.imooc.map;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName Map-Basic map基础接口
 * @Description
 * @Date 2018年05月23日23:32:12
 */
public interface Map<K, V> {

    /**
     * 增加k-v
     *
     * @param key
     * @param value
     */
    void add(K key, V value);

    /**
     * 删除键所对应的数值
     *
     * @param key
     * @return
     */
    V remove(K key);

    /**
     * 是否包含key
     *
     * @param key
     * @return
     */
    boolean contains(K key);

    /**
     * 通过键获取值
     *
     * @param key
     * @return
     */
    V get(K key);

    /**
     * 根据键设置值
     * @param key
     * @param newValue
     */
    void set(K key, V newValue);

    /**
     * 获取Map大小
     * @return
     */
    int getSize();

    /**
     * 判断Map是否为空
     * @return
     */
    boolean isEmpty();

}
