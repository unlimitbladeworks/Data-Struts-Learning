package com.imooc.linkedlist;

import com.imooc.stacks.Stack;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName LinkedListStack
 * @Description 链表栈实现栈接口,全程调用LinkedList数据结构实现栈的功能
 * @Date 2018/5/6 13:46
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack(){
        list = new LinkedList<>();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeLast();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: top ");
        sb.append(list);
        return sb.toString();
    }
}
