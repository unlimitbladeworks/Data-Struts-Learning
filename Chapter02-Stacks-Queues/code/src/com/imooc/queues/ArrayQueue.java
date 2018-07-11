package com.imooc.queues;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName ArrayQueue
 * @Description 数组队列
 * @Date 2018/4/29 21:28
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getHead() {
        return array.getFirst();
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
     * 获取队列容器的容积
     *
     * @return
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue:");
        sb.append("head [");
        for (int i = 0; i < array.getSize(); i++) {
            sb.append(array.get(i));
            if (i != array.getSize() - 1) {
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }
}
