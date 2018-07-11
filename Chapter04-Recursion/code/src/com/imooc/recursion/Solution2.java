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
 *
 * 有虚拟头结点的
 * @Date 18-5-7 下午10:10
 */

public class Solution2 {

    public ListNode removeElements(ListNode head, int val) {

        //设置虚拟头结点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;

        while (prev.next != null) {
            if (prev.next.val == val){
//                ListNode delNode = prev.next;
//                prev.next = delNode.next;
//                delNode.next = null;
                //与上面三步操作一个原理
                prev.next = prev.next.next;
            }else {
                prev = prev.next;
            }
        }

        return dummyHead.next;
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

        Solution2 solution2 = new Solution2();
        solution2.removeElements(listNode, 6);
        System.out.println(listNode);
    }
}

