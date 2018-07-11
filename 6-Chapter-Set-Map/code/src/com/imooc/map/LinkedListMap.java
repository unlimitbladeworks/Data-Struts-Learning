package com.imooc.map;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName LinkedListMap
 * @Description 基于LinkedList实现的Map类
 * @Date 2018年05月24日22:17:38
 */
public class LinkedListMap<K, V> implements Map<K, V> {

    private class Node {
        /**
         * Node中的Key
         */
        public K key;
        /**
         * Node中的value
         */
        public V value;
        /**
         * Node中的next节点
         */
        public Node next;


        public Node(K key, V vaule, Node next) {
            this.key = key;
            this.value = vaule;
            this.next = next;
        }

        public Node(K key,V value) {
            this(key, value, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + ":" + value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    /**
     * 构造获取Key对应的Node
     *
     * @param key 用户传入的key值
     * @return
     */
    private Node getNode(K key) {
        Node current = dummyHead.next;
        while (current != null) {
            if (current.key.equals(key)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    /**
     * 添加操作
     * @param key 键
     * @param value 键对应的值
     */
    @Override
    public void add(K key, V value) {

        Node node = getNode(key);
        if (node == null) {
            //虚拟头结点的下一个节点创建新的节点
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        } else {
            node.value = value;
        }
    }

    /**
     * 根据key删除value
     * @param key 用户传入的键
     * @return 返回删除的值
     */
    @Override
    public V remove(K key) {

        //从虚拟头结点开始遍历,若与key相等直接跳出循环
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.key.equals(key)) {
                break;
            }
            prev = prev.next;
        }

        //断开要删除节点的next,将前一个节点指向删除节点的下一个节点
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            return delNode.value;
        }
        return null;
    }

    /**
     * 判断是否有此键
     * @param key
     * @return
     */
    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    /**
     * 获取对应键的值
     * @param key 键
     * @return 返回值
     */
    @Override
    public V get(K key) {
        Node node = getNode(key);
        //获取节点若为null,则返回null ,否则返回该节点的值
        return node == null ? null : node.value;
    }

    /**
     * 更新操作
     * @param key 键
     * @param newValue 更新的新值
     */
    @Override
    public void set(K key, V newValue) {

        Node node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException(key + "doesn't exist!");
        }
        //若有,更新节点为用户传进来的新值
        node.value = newValue;
    }

    /**
     * 返回size
     * @return
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 判断是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
