package com.imooc.stacks;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName ArrayStack
 * @Description 数组栈实现栈接口
 * @Date 18-4-27 下午9:54
 */
public class ArrayStack<E> implements Stack<E> {

    Array<E> array;

    /**
     * 栈的容积构造方法
     *
     * @param capacity 容积分子
     */
    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    /**
     * 栈的默认构造器
     */
    public ArrayStack() {
        array = new Array<>();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 获取栈的容积
     *
     * @return 容积个数
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    /**
     * 重写toString方法
     * @return 字符串
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: ");
        sb.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            sb.append(array.get(i));
            if (i != array.getSize() - 1) {
                sb.append(",");
            }
        }
        sb.append("] top ");
        return sb.toString();
    }
}
