package com.imooc.set;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName BinarySearchTreeBasic
 * @Description 二分搜索树-最终版(递归调用)
 * @Date 2018年05月17日22:08:10
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
        } else if (e.compareTo(node.e) > 0){
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


    /**
     * 使用栈实现非递归二叉树前序遍历 (二分树的深度优先遍历)
     * NR:No Recursion 非递归
     */
    public void preOrderNR() {

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.println(current.e);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    /**
     * 二分搜索树的层序遍历(广度优先遍历)
     */
    public void levelOrder() {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.remove();
            System.out.println(current.e);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
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

    /**
     * 寻找二分树的最小值
     *
     * @return
     */
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }

        return minimum(root).e;
    }

    /**
     * 返回以node为根的二分搜索树的最小节点
     *
     * @param node 节点
     * @return
     */
    private Node minimum(Node node) {

        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 寻找二分树的最大值
     *
     * @return
     */
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return maximum(root).e;
    }

    /**
     * 返回以node为根的二分搜索树的最大节点
     *
     * @param node 节点
     * @return
     */
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 从二分搜索树中删除最小值所在的节点，返回最小值
     *
     * @return
     */
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除以node为根的二分搜索树中的最小节点
     * 返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @return
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }


    /**
     * 从二分搜索树中删除最大值所在的节点，返回最大值
     *
     * @return
     */
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    /**
     * 删除以node为根的二分搜索树中的最大节点
     * 返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @return
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 删除二分搜索树中的某个元素
     *
     * @param e
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    /**
     * 删除掉以node为根的二分搜索树中值为e的节点, 递归算法
     * 返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @param e
     * @return
     */
    private Node remove(Node node, E e) {
        if (node == null) {
            return node;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else { //e.compareTo(node.e) == 0
            // 待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            // successor :后继节点, precursor : 前驱节点(待实现)
            Node successor = new Node(minimum(node.right).e);
            size++;

            //将待删除节点的右子树找出最小节点元素删除并且将右树返回到前驱节点的右子树上
            successor.right = removeMin(node.right);
            //待删除节点左子树对接到前驱节点的左子树上
            successor.left = node.left;

            //断开待删除节点的左右子树
            node.left = node.right = null;
            size--;

            return successor;
        }
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
