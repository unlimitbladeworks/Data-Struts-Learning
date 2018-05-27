package com.imooc.map;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName Solution
 * @Description LeetCode 349. 两个数组的交集
 * 给定两个数组，写一个函数来计算它们的交集。
 * 例子:
 * 给定 num1= [1, 2, 2, 1], nums2 = [2, 2], 返回 [2].
 * 提示:
 * 每个在结果中的元素必定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * @Date 2018/5/27 11:40
 */
public class Solution {

    public static int[] intersection(int[] nums1, int[] nums2) {

        TreeSet<Integer> treeSet = new TreeSet<>();
        //遍历数组1,将数组元素添加到TreeSet中,去除重复元素
        for (int i : nums1) {
            treeSet.add(i);
        }

        ArrayList<Integer> list = new ArrayList<>();
        //遍历数组2,如果set中包含数组2的元素,则放入list中,并且为了去重,将放入的元素从原有的set中去除掉
        for (int i : nums2) {
            if (treeSet.contains(i)) {
                list.add(i);
                treeSet.remove(i);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = intersection(num1, nums2);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
