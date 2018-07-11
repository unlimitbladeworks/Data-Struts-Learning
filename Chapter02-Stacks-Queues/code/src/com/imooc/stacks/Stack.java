package com.imooc.stacks;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName Stack
 * @Description 栈的接口类
 * @Date 2018/4/27 14:21
 */
public interface Stack<E> {

    /**
     * 入栈(压栈)操作
     * @param e 泛型元素
     */
    void push(E e);

    /**
     * 出栈(弹出栈)操作
     * @return 返回出栈元素
     */
    E pop();

    /**
     * peek:瞥一眼的意思
     * 查看栈顶第一个元素的值
     * @return 返回栈顶元素
     */
    E peek();

    /**
     * 获取栈的大小
     * @return 返回大小
     */
    int getSize();

    /**
     * 判断栈是否为空
     * @return 返回是否为空
     */
    boolean isEmpty();


}
