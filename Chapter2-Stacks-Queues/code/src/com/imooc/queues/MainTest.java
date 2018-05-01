package com.imooc.queues;

import com.imooc.stacks.ArrayStack;
import org.junit.Test;

import java.util.Random;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName MainTest
 * @Description 队列的测试类
 * @Date 2018/4/27 14:28
 */
public class MainTest {

    /**
     * 测试数组队列的入队、出队
     */
    @Test
    public void testArrayQueue() {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

    /**
     * 测试数组队列和循环队列的时间消耗测试方法
     */
    @Test
    public void testTimeComplexity() {
        //循环次数
        int operateCount = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double arrayQueueTime = testQueue(arrayQueue,operateCount);
        System.out.println("ArrayQueue's Time:" + arrayQueueTime + "s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double loopQueueTime = testQueue(loopQueue,operateCount);
        System.out.println("LoopQueue's Time:" + loopQueueTime + "s");

    }

    /**
     * 测试数组队列和循环队列的耗时时间
     * 一个时间复杂度是O(n^2),ArrayQueue
     * 一个时间复杂度是O(1),LoopQueue
     *
     * @return
     */
    public static double testQueue(Queue<Integer> queue, int operateCount) {

        //开始时间
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < operateCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < operateCount; i++) {
            queue.dequeue();
        }
        //结束时间
        long endTime = System.nanoTime();

        //纳秒和秒相差10^9次方
        return (endTime - startTime) / 1000000000.0;
    }
}
