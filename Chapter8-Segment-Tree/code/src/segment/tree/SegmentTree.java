package segment.tree;

import java.util.Arrays;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName SegmentTree
 * @Description 线段树的基础实现
 * @Date 18-6-5 下午9:37
 */
public class SegmentTree<E> {

    /**
     * 初始化数组tree
     */
    private E[] tree;

    /**
     * 初始化数组
     */
    private E[] data;

    /**
     * 初始融合器
     */
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {

        //初始化融合器
        this.merger = merger;

        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        //构造4倍长度
        tree = (E[]) new Object[arr.length * 4];
        buildSegmentTree(0, 0, arr.length - 1);
    }

    /**
     * 创建线段树的方法
     * 在treeIndex的位置,创建[l....r]区间
     *
     * @param treeIndex 线段树的根节点
     * @param l         区间的左索引
     * @param r         区间的右索引
     */
    private void buildSegmentTree(int treeIndex, int l, int r) {

        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }

        //返回左孩子树的索引
        int leftTreeIndex = this.leftChild(treeIndex);
        //返回右孩子树的索引
        int rightTreeIndex = this.rightChild(treeIndex);

        /*
         * 此处不写 (l + r)/2 的原因是:
         *  怕数字太大导致整型溢出,下面写法与此写法计算中间值是一样的.
         */
        int mid = l + (r - l) / 2;
        //创建左线段 子树
        buildSegmentTree(leftTreeIndex, l, mid);
        //创建右线段 子树
        buildSegmentTree(rightTreeIndex, mid + 1, r);
        //综合左右两个线段信息,得到大的线段信息
        tree[treeIndex] = merger.merger(tree[leftTreeIndex], tree[rightTreeIndex]);

    }

    /**
     * 获取树的大小
     *
     * @return
     */
    public int getSize() {
        return data.length;
    }

    /**
     * 根据索引获取元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal!");
        }
        return data[index];
    }

    /**
     * 返回完全二叉树的数组表示中,一个索引所表示的元素的左孩子节点的索引
     *
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * 返回完全二叉树的数组表示中,一个索引所表示的元素的右孩子节点的索引
     *
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                stringBuilder.append(tree[i]);
            } else {
                stringBuilder.append("null");
            }
            if (i != tree.length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
