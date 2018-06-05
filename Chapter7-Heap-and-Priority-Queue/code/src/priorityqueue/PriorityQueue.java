package priorityqueue;

import com.imooc.queues.Queue;
import heap.MaxHeap;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName PriorityQueue
 * @Description 基于最大堆实现优先队列
 * @Date 2018/6/2 22:47
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    /**
     * 优先队列的默认构造函数
     */
    public PriorityQueue(){
        maxHeap = new MaxHeap<>();
    }

    /**
     * 入队操作
     * @param e 泛型元素
     */
    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    /**
     * 出队操作
     * @return
     */
    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getHead() {
        return maxHeap.findMax();
    }

    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }
}
