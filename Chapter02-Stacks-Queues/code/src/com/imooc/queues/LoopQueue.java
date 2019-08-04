package com.imooc.queues;

import java.util.Arrays;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName LoopQueue
 * @Description 循环队列的实现
 * @Date 2018/4/29 22:17
 */
public class LoopQueue<E> implements Queue<E> {

    /**
     * 初始化泛型数组
     */
    private E[] data;

    /**
     * 队列头索引，尾索引
     */
    private int head, tail;

    /**
     * 队列的数量
     */
    private int size;

    public LoopQueue(int capacity) {
        //此处因为需要循环队列,所以预留放空一个队列的位置
        data = (E[]) new Object[capacity + 1];
        head = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        //减一目的是因为浪费了一个空间，所以可用长度就是全部减一
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == head) {
            //此处getCapacity,而不是data.length,因为有意义的预留了一个空间
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        //所有%data.length的目的是利用余数循环 ->(最大容积-1) 的索引值
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * 扩容的重塑方法
     *
     * @param newCapacity 新的容量
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            //所有%data.length的目的是利用余数循环 ->(最大容积-1) 的索引值
            newData[i] = data[(i + head) % data.length];
        }
        data = newData;
        head = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Can't dequeue from an empty queue.");
        }
        E ret = data[head];
        data[head] = null;
        //所有%data.length的目的是利用余数循环 ->(最大容积-1) 的索引值
        head = (head + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getHead() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Can't dequeue from an empty queue.");
        }
        return data[head];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: size = %d , capacity = %d %n", size, getCapacity()));
        sb.append("head [");
        for (int i = head; i != tail; i = (i + 1) % data.length) {
            sb.append(data[i]);
            if ((i + 1) % data.length != tail) {
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }

    /**
     * 测试循环队列的主方法
     * @param args
     */
    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue);

            if (i % 3 == 2) {
                loopQueue.dequeue();
                System.out.println(loopQueue);
            }
        }
    }
}
