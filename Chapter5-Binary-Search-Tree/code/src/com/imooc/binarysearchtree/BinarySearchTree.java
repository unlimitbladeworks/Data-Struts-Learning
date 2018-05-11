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
     * @return 树容量
     */
    public int getSize(){
        return size;
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }


}
