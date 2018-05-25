package com.imooc.map;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName BSTMap
 * @Description 基于二分搜索树创建的Map
 * @Date 2018/5/25 22:07
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    /**
     * 创建树节点
     */
    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    /**
     * 根节点
     */
    private Node root;
    /**
     * BSTMap大小
     */
    private int size;

    /**
     * 构造函数
     */
    public BSTMap() {
        root = null;
        size = 0;
    }


    @Override
    public void add(K key, V value) {
        //添加根节点k-v值
        root = add(root, key, value);
    }

    /**
     * 二叉树递归添加K-V方法
     *
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            add(node.right, key, value);
        }
        return node;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void set(K key, V newValue) {

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
