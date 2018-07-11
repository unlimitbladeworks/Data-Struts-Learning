package com.imooc.recursion;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName RecursionDebug
 * @Description 递归链表删除问题, 打印输出的解决思路
 * @Date 18-5-10 下午10:32
 */
public class RecursionDebug {


    /**
     * 递归实现leetCode上的203题
     * 递归删除链表节点
     *
     * @param head  链表
     * @param val   链表值
     * @param depth 递归深度
     * @return
     */
    public ListNode removeElements(ListNode head, int val, int depth) {

        String depthString = generateDepthString(depth);
        System.out.print(depthString);
        System.out.println("Call: remove " + val + " in " + head);

        //如果传入节点为空,则返回空
        if (head == null) {
            System.out.print(depthString);
            System.out.println("Return: " + head);
            return null;
        }

        /**
         * 递归自身函数,进行删除调用
         * 当链表的值等于传入要删除的值,指向下一节点
         */
        ListNode result = removeElements(head.next, val, depth + 1);
        System.out.print(depthString);
        System.out.println("After remove " + val + ":" + result);

        ListNode ret;
        //如果当前头结点的值等于要删除的值,将返回值给ret,否则将头结点赋予ret
        if (head.val == val) {
            ret = result;
        } else {
            head.next = result;
            ret = head;
        }
        System.out.print(depthString);
        System.out.println("Return: " + ret);
        return ret;
    }

    /**
     * 根据递归深度生成debug打印时的信息
     * @param depth 递归深度
     * @return
     */
    private String generateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 6, 4, 5, 6};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);

        RecursionDebug recursionDebug = new RecursionDebug();
        recursionDebug.removeElements(listNode, 6, 0);
        System.out.println(listNode);
    }
}
