package com.imooc.linkedlist;

import com.imooc.queues.Queue;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName LinkedListQueue
 * @Description 实现第二章中的Queue的接口进行编写
 * @Date 2018/5/6 15:30
 */
public class LinkedListQueue<E> implements Queue<E> {


    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node() {
            this(null, null);
        }

        public Node(E e) {
            this(e, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /**
     * 虚拟出head节点，tail节点
     */
    private Node head, tail;

    /**
     * 链表队列的大小
     */
    private int size;

    /**
     * 初始化构造函数,显示写出来
     */
    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * 入队
     *
     * @param e 泛型元素
     */
    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    /**
     * 出队
     *
     * @return
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Can't dequeue from an empty queue.");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return retNode.e;
    }

    /**
     * 获取第一个队列的第一个元素
     *
     * @return
     */
    @Override
    public E getHead() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Can't dequeue from an empty queue.");
        }
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: head ");

        Node current = head;
        while (current != null) {
            sb.append(current + "->");
            current = current.next;
        }
        sb.append("NULL tail ");
        return sb.toString();
    }


    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
