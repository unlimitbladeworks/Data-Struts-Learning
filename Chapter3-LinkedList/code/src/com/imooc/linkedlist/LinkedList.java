package com.imooc.linkedlist;
/**
 * @ClassName LinkedList
 * @Description 最基础的动态数据结构--链表
 * @author suyu
 * @Date 2018/5/1 21:52
 * @version 1.0.0
 */
public class LinkedList<E> {

    /**
     * 此处设计Node节点类为内部类，目的如下：
     * 我们写的是数据结构的底层代码，给客户使用的时候，客户无需关注此数据结构有什么属性，
     * 使用的时候需要关注怎么用即可，所以Node设置为内部类，对客户端使用而言，是屏蔽的操作。
     */
    private class Node{
        /**
         * 链表的数据元素
         */
        public E e;
        /**
         * 链表的节点指向
         */
        public Node next;

        /**
         * 带数据和指针的构造函数,用户传进来的
         * @param e 数据元素e
         * @param next 链表指针
         */
        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        /**
         * 有参构造，用户传入一个数据元素e
         * @param e 数据e
         */
        public Node(E e){
            this(e,null);
        }

        /**
         * 默认的构造函数，无参，直接都传null
         */
        public Node(){
            this(null,null);
        }

    }
}
