package com.imooc.binarysearchtree;

import org.junit.Test;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName MainTest
 * @Description 二分搜索树的测试类
 * @Date 2018/5/13 19:52
 */
public class MainTest {

    @Test
    public void testOrder() {
        BinarySearchTreeLevelUp<Integer> bst = new BinarySearchTreeLevelUp<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }
        //添加二分搜索树时,应该如下结构添加
        ///////////////////
        //       5       //
        //     /  \      //
        //    3    6     //
        //   / \    \    //
        //  2  4     8   //
        ///////////////////
        //前序遍历树结构
        bst.preOrder();
        System.out.println();
        System.out.println(bst);

        //非递归遍历树结构(深度优先遍历)
        bst.preOrderNR();
        System.out.println();

        //层次遍历(广度优先遍历)
        bst.levelOrder();
        System.out.println();

        //中序遍历
        bst.midOrder();
        System.out.println();

        //后序遍历
        bst.postOrder();
        System.out.println();



    }
}
