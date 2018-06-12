package segment.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName NumArray
 * @Description leetCode303 -- use SegmentTree
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * @Date 2018年06月12日21:09:37
 */
public class NumArray {

    private static SegmentTree<Integer> segmentTree;



    public NumArray(int[] nums) {

        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(data, (a, b) -> a + b);
        }

    }

    public static int sumRange(int i, int j) {

        if (segmentTree == null){
            throw new IllegalArgumentException("Segment Tree is null!");
        }
        return segmentTree.query(i,j);
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(sumRange(0, 2));
    }
}
