package com.imooc.binarysearchtree;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName BinarySearchTreeBasic
 * @Description 二分搜索树-进阶版(递归调用)
 * @Date 2018/5/11 22:27
 */
public class BinarySearchTreeLevelUp<E extends Comparable<E>> {

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
    public BinarySearchTreeLevelUp() {
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
        root = add(root, e);
    }

    /**
     * 向以node为根的二分搜索树中插入E,递归算法
     * 返回插入新节点后二分搜索树的根
     *
     * @param node
     * @param e
     */
    private Node add(Node node, E e) {

        //判断节点是否为空,若为空,则返回作为根节点
        if (node == null) {
            size++;
            return new Node(e);
        }

        //再次递归调用,调用这个私有的自身方法
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else {
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * 判断二分搜索树是否包含元素E
     *
     * @param e 插入的数据
     * @return 是否包含
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 看以node为根的二分搜索树中是否包含元素e, 递归算法
     *
     * @param node 以node为根的二分搜索树
     * @param e    插入的数据
     * @return
     */
    private boolean contains(Node node, E e) {

        //如果为空,返回false
        if (node == null) {
            return false;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        }
        // e.compareTo(node.e) > 0
        else {
            return contains(node.right, e);
        }
    }

    //前序遍历
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历以node为根的二分搜索树，递归算法
     * <p>
     * 前序遍历:先根结点然后遍历左子树，最后遍历右子树。
     * <p>
     * 若二叉树为空则结束返回，否则：
     * （1）访问根结点。
     * （2）前序遍历左子树。
     * （3）前序遍历右子树 。
     * 需要注意的是：遍历左右子树时仍然采用前序遍历方法。
     *
     * @param node
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //中序遍历
    public void midOrder() {
        midOrder(root);
    }

    /**
     * 中序遍历
     * （1）中序遍历左子树
     * （2）访问根结点
     * （3）中序遍历右子树
     * <p>
     * 规律:从小到大排序的遍历顺序
     *
     * @param node
     */
    private void midOrder(Node node) {

        if (node == null) {
            return;
        }

        midOrder(node.left);
        System.out.println(node.e);
        midOrder(node.right);

    }

    //后序遍历
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 若二叉树为空则结束返回，
     * 否则：
     * （1）后序遍历左子树
     * （2）后序遍历右子树
     * （3）访问根结点
     * 应用:
     * 二分搜索树释放内存
     *
     * @param node
     */
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateBSTString(root, 0, sb);
        return sb.toString();
    }

    /**
     * 生成以node 为根节点，深度为depth并且描述二叉树的字符串
     *
     * @param node
     * @param depth
     * @param sb
     */
    private void generateBSTString(Node node, int depth, StringBuilder sb) {
        if (node == null) {
            sb.append(generateDepthString(depth) + "null\n");
            return;
        }
        sb.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, sb);
        generateBSTString(node.right, depth + 1, sb);
    }

    private String generateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }
}
