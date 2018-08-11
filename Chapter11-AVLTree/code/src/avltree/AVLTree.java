package avltree;


import java.util.ArrayList;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName AVLTree
 * @Description AVLTree的实现 version1.0
 * @Date 2018/8/5 10:19
 */
public class AVLTree<K extends Comparable<K>, V> {

    /**
     * 创建树节点
     */
    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height = 1;
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
    public AVLTree() {
        root = null;
        size = 0;
    }

    /**
     * 获取树的高度
     *
     * @param node
     * @return
     */
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    /**
     * 获取树的平衡因子
     *
     * @param node
     * @return
     */
    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    // 对节点y进行向右旋转操作,返回旋转后新的根节点x
    //          y                          x
    //         / \                       /  \
    //        x   T4    向右旋转(y)      z    y
    //       / \     -------------->  / \   / \
    //      z  T3                    T1 T2 T3 T4
    //     / \
    //    T1  T2

    private Node rightRotate(Node y) {
        //看上图就可以很容易写出来
        Node x = y.left;
        Node T3 = x.right;

        //向右旋转,
        x.right = y;
        y.left = T3;

        //更新height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;

    }

    /**
     * 判断该二叉树是否是一颗二分搜索树
     *
     * @return
     */
    public boolean isBST() {
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);
        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断该二叉树是否是一颗平衡树
     *
     * @return
     */
    public boolean isBalanced() {
        return isBalanced(root);
    }

    /**
     * 判断以Node为根的二叉树是否是一颗平衡二叉树,递归算法
     *
     * @param node
     * @return
     */
    private boolean isBalanced(Node node) {

        if (node == null) {
            return true;
        }
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);

    }

    /**
     * 中序遍历
     *
     * @param node
     * @param keys
     */
    private void inOrder(Node node, ArrayList<K> keys) {
        if (node == null) {
            return;
        }

        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }


    public void add(K key, V value) {
        //添加二分搜索树添加元素：根节点k-v值
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
        //如果节点为空,创建新的树节点
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        //传入的值与树节点做对比,小于递归左子树,大于递归右子树
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else { //key.compareTo(node.key) == 0
            node.value = value;
        }

        //更新height,左右子树的
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            System.out.println("unbalanced:" + balanceFactor);
        }

        //平衡维护
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            rightRotate(node);

        }

        return node;
    }


    /**
     * 返回以node为根的二分搜索树的最小值所在节点
     *
     * @param node node节点
     * @return
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 删除掉以node为根的二分搜索树中的最小节点
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
     * 删除以node为根的二分搜索树中key的节点，递归算法
     *
     * @param node
     * @param key
     * @return 删除节点后的新节点
     */
    private Node remove(Node node, K key) {

        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else { //key.compareTo(node.key)==0
            //删除左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //删除右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }


            //删除左右子树都不为空的情况
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            return successor;
        }
    }


    /**
     * 返回以node为根节点的二分搜索树中，key所在的节点
     * 递归遍历,根据传入的key值判断与节点的key值相比较,左右递归
     *
     * @param node 树节点
     * @param key  key值
     * @return node节点
     */
    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        //如果key等于节点中的key,返回node,否则遍历找下去
        if (key.equals(node.key)) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }

    /**
     * 根据getNode方法判断是否包含节点
     *
     * @param key
     * @return
     */
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    /**
     * 获取对应键的值
     *
     * @param key
     * @return
     */
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    /**
     * 根据key,更新对应的value值
     *
     * @param key
     * @param newValue
     */
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + "doesn't exist!");
        }
        node.value = newValue;
    }


    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}