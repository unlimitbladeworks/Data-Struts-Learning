package heap;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName MaxHeap
 * @Description 最大堆
 * @Date 18-5-28 下午9:22
 */
public class MaxHeap<E extends Comparable<E>> {

    /**
     * 引入数组作为堆的实现
     */
    private Array<E> data;

    /**
     * 知道初始容器的构造函数
     *
     * @param capacity 初始化容量因子
     */
    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    /**
     * 默认无参构造函数
     */
    public MaxHeap() {
        data = new Array<>();
    }

    /**
     * 返回堆中个数
     *
     * @return int个数
     */
    public int getSize() {
        return data.getSize();
    }

    /**
     * 判断堆是否为空
     *
     * @return boolean是否为空
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树的数组表示中,一个索引所表示的元素的父亲节点的索引
     *
     * @param index 传入的索引值
     * @return 父亲节点的索引
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't hava parent!");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树的数组表示中,一个索引所表示的元素的左孩子节点的索引
     *
     * @param index 传入的索引值
     * @return 左孩子节点的索引
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中,一个索引所表示的元素的右孩子节点的索引
     *
     * @param index 传入的索引值
     * @return 右孩子节点的索引
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 堆中插入元素
     * 实现思路:通过动态数组实现,向数组索引末尾处添加元素
     * 若子节点比父节点大,则交换位置
     * if child's Node > parent's Node:
     *     swap(siftUp)
     *
     * @param e 元素
     */
    public void add(E e) {
        data.addLast(e);
        //数组最后一位索引,减1是因为索引从0开始
        siftUp(data.getSize() - 1);
    }

    /**
     * 堆的上浮方法,比较父-子节点
     * @param i
     */
    private void siftUp(int i) {




    }
}
