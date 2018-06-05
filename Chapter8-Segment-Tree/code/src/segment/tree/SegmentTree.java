package segment.tree;

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

    public SegmentTree(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        //构造4倍长度
        tree = (E[]) new Object[arr.length * 4];
    }

    /**
     * 获取树的大小
     * @return
     */
    public int getSize() {
        return data.length;
    }

    /**
     * 根据索引获取元素
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
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * 返回完全二叉树的数组表示中,一个索引所表示的元素的右孩子节点的索引
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return 2 * index + 2;
    }


}
