package com.imooc.binarysearchtree;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName BinarySearchTree
 * @Description 二分搜索树
 * @Date 2018/5/11 22:27
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private class Node {
        /**
         * 树节点的存储元素
         */
        public E e;
        /**
         * 左子树,右子树
         */
        public Node left, right;


        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    /**
     * 树的根节点
     */
    private Node root;

    /**
     * 树的容量
     */
    private int size;

    /**
     * 初始化二分搜索树
     */
    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    /**
     * 获取树的容量
     *
     * @return 树容量
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向二分搜索树中添加数据
     *
     * @param e 添加的数据
     */
    public void add(E e) {

        //如果根节点是空,创建根节点,维护size容量增加
        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            add(root, e);
        }
    }

    /**
     * 向以node为根的二分搜索树中插入E,递归算法
     *
     * @param node
     * @param e
     */
    private void add(Node node, E e) {

        /**
         * 插入的e与当前的e相等,不做处理
         * 如果插入的e小于当前根节点的e,并且根节点的左孩子为空，则添加e到根节点的左孩子处
         * 如果插入的e大于当前根节点的e,并且根节点的右孩子为空，则添加e到根节点的右孩子处
         */
        if (e.equals(node.e)) {
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }
        //再次递归调用,调用这个私有的自身方法
        if (e.compareTo(node.e) < 0) {
            add(node.left, e);
        } else {
            add(node.right, e);
        }
    }


}
