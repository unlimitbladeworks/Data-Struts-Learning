package com.imooc.linkedlist;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName LinkedListQuery
 * @Description
 * @Date 18-5-3 下午9:19
 */
public class LinkedList<E> {


    /**
     * 此处设计Node节点类为内部类，目的如下：
     * 我们写的是数据结构的底层代码，给客户使用的时候，客户无需关注此数据结构有什么属性，
     * 使用的时候需要关注怎么用即可，所以Node设置为内部类，对客户端使用而言，是屏蔽的操作。
     */
    private class Node {
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
         *
         * @param e    数据元素e
         * @param next 链表指针
         */
        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        /**
         * 有参构造，用户传入一个数据元素e
         *
         * @param e 数据e
         */
        public Node(E e) {
            this(e, null);
        }

        /**
         * 默认的构造函数，无参，直接都传null
         */
        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /**
     * 虚拟头结点指针
     */
    private Node dummyHead;
    /**
     * 链表的大小
     */
    private int size;

    public LinkedList() {
        //初始化虚拟头指针,存在节点即是一个null
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * 获取链表的大小
     *
     * @return 返回链表大小
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断链表是否为空
     *
     * @return 是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 链表中间插入的元素
     *
     * @param index "索引",所谓的索引并不是真索引,方便定义而已
     * @param e     添加的数据元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index");
        }
        //1.假设要插入的元素node名字为prev,并且从链表的虚拟头节点进行初始化
        Node prev = dummyHead;
        //2.循环遍历,从dummyHead开始遍历,0,1,2,3.....index之前的节点
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        //3.将插入的node.next指向prev的next
//        Node node = new Node(e);
//        node.next = prev.next;
//        prev.next = node;

        //优雅的写法:与addFirst中一样,上面三行的注释
        prev.next = new Node(e, prev.next);
        size++;
    }

    /**
     * 链表头部新增节点
     *
     * @param e 新增元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 链表最后添加元素
     *
     * @param e 数据元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获取链表的第index(0-based)个位置的元素
     * 在链表中不是一个常用的操作,此处是练习用 :)
     *
     * @param index 索引位置
     * @return 元素数据
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index!");
        }
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.e;
    }

    /**
     * 获取链表的第一个元素
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取链表最后一个元素
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }


    /**
     * 根据索引移除相应的元素位置
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Illegal index!");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    /**
     * 删除链表第一个元素
     * @return 元素节点
     */
    public E removeFirst() {
        return remove(0);
    }
    /**
     * 删除链表最后一个元素
     * @return 元素节点
     */
    public E removeLast() {
        return remove(size - 1);
    }


    /**
     * 获取链表的第index(0-based)个位置的元素
     * 在链表中不是一个常用的操作,此处是练习用 :)
     *
     * @param index 索引位置
     * @param e     元素
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Illegal index");
        }
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.e = e;
    }

    /**
     * 判断是否包含元素
     *
     * @param e 数据元素
     * @return
     */
    public boolean contains(E e) {
        Node current = dummyHead.next;
        while (current != null) {
            if (current.e.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //1.第一中写法
//        Node current = dummyHead.next;
//        while (current != null) {
//            sb.append(current + "->");
//            current = current.next;
//        }

        //2.第二种写法
        for (Node current = dummyHead.next; current != null; current = current.next) {
            sb.append(current + "->");
        }
        sb.append("NULL");
        return sb.toString();
    }
}
