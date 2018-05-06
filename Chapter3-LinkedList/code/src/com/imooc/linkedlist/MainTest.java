package com.imooc.linkedlist;

import com.imooc.queues.ArrayQueue;
import com.imooc.queues.LoopQueue;
import com.imooc.queues.Queue;
import com.imooc.stacks.ArrayStack;
import com.imooc.stacks.Stack;
import org.junit.Test;

import java.util.Random;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName MainTest
 * @Description test LinkedList's Class
 * @Date 18-5-3 22:11
 */
public class MainTest {

    /**
     * linkedList测试类
     */
    @Test
    public void testLinkedList(){
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2,666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);

    }

    /**
     * 测试linkedList栈，出入栈
     */
    @Test
    public void testLinkedListStack() {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }


    /**
     * 测试数组栈和链表栈的时间消耗测试方法
     */
    @Test
    public void testTimeComplexity() {
        //循环次数
        int operateCount = 100000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double arrayStackTime = testStack(arrayStack,operateCount);
        System.out.println("arrayStackTime's Time:" + arrayStackTime + "s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double linkedListStackTime = testStack(linkedListStack,operateCount);
        System.out.println("linkedListStackTime's Time:" + linkedListStackTime + "s");

    }

    /**
     * 测试数组栈和链表栈的耗时时间
     * 一个是ArrayStack
     * 一个是LinkedListStack
     * 二者时间复杂度是差不多的,和cpu，
     * 我的测试结果：
     * arrayStackTime's Time:0.017628613 s
     * linkedListStackTime's Time:14.658062033 s
     * @return
     */
    public static double testStack(Stack<Integer> stack, int operateCount) {

        //开始时间
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < operateCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < operateCount; i++) {
            stack.pop();
        }
        //结束时间
        long endTime = System.nanoTime();

        //纳秒和秒相差10^9次方
        return (endTime - startTime) / 1000000000.0;
    }




    /**
     * 测试数组队列和循环队列的时间和链表队列的消耗测试方法
     */
    @Test
    public void testTimeComplexityQueue() {
        //循环次数
        int operateCount = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double arrayQueueTime = testQueue(arrayQueue,operateCount);
        System.out.println("ArrayQueue's Time:" + arrayQueueTime + "s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double loopQueueTime = testQueue(loopQueue,operateCount);
        System.out.println("LoopQueue's Time:" + loopQueueTime + "s");

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double linkedListQueueTime = testQueue(linkedListQueue,operateCount);
        System.out.println("linkedListQueueTime's Time:" + linkedListQueueTime + "s");

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
