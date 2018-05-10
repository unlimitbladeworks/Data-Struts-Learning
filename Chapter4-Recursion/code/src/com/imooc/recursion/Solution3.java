package com.imooc.recursion;

public class Solution3 {

    /**
     * 递归实现leetCode上的203题
     * 递归删除链表节点
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {

        //如果传入节点为空,则返回空
        if (head == null){
            return null;
        }

        /**
         * 递归自身函数,进行删除调用
         * 当链表的值等于传入要删除的值,指向下一节点
         */
        head.next = removeElements(head.next,val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 6, 4, 5, 6};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);

        Solution3 solution3 = new Solution3();
        solution3.removeElements(listNode, 6);
        System.out.println(listNode);
    }
}
