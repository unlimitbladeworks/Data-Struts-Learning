package com.imooc.queues;
/**
 * @ClassName Queue
 * @Description 队列的接口，定义了抽象的方法
 * @author suyu
 * @Date 2018/4/29 21:13
 * @version 1.0.0
 */
public interface Queue<E> {

    /**
     * 入队列
     * @param e 泛型元素
     */
    void enqueue(E e);

    /**
     * 出队列
     * @return e 泛型元素
     */
    E dequeue();

    /**
     * 拿到队列头
     * @return e 泛型元素
     */
    E getHead();

    /**
     * 获取队列的数量大小
     * @return 数量大小
     */
    int getSize();

    /**
     * 队列是否为空
     * @return 是否为空
     */
    boolean isEmpty();


}
