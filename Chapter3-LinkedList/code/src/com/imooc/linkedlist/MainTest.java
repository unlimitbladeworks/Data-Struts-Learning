package com.imooc.linkedlist;

import org.junit.Test;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName MainTest
 * @Description test LinkedListBasic's Class
 * @Date 18-5-3 22:11
 */
public class MainTest {

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
}
