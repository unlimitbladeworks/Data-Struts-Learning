package com.imooc.recursion;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName Solution
 * @Description leetCode 题库203题
 * <p>
 * 删除链表中等于给定值 val 的所有节点。
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * @Date 18-5-7 下午10:10
 */

public class Solution {

    public ListNode removeElements(ListNode head, int val) {

        //如果节点不为空且节点的值等于给定要删除的值
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
            //与上面三步操作一个原理
//            head = head.next;
        }

        if (head == null) {
            return head;
        }

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
                //与上面三步操作一个原理
//                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }

        return head;
    }

    /**
     * leetCode 203 题,自己先实现一个listNode节点的方法，在进行自己的测试类测试
     * debug 发现，链表就是在无限递归,添加Node时,value存入Node1中,而Node1的
     * next是null,继续添加时,Node2中的value填充Node1的next节点,而Node2本身的next依然是空。
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 6, 4, 5, 6};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);

        Solution solution = new Solution();
        solution.removeElements(listNode, 6);
        System.out.println(listNode);
    }
}

