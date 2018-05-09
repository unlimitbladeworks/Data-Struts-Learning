package com.imooc.recursion;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName Sum
 * @Description 求和分解递归
 * @Date 18-5-9 下午9:58
 */
public class Sum {

    /**
     * 解决的是sum(l,.....n)范围数字里的和
     * 将问题最小化
     * @param arr
     * @param l
     * @return
     */
    public static int sum(int[] arr, int l) {
        //最基本问题
        if (l == arr.length) {
            return 0;
        }
        //此逻辑就是将问题最小化
        return arr[l] + sum(arr, l + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(sum(arr,0));
    }
}
