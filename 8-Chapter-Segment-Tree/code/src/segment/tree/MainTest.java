package segment.tree;

import org.junit.Test;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName MainTest
 * @Description 线段树的测试用例
 * @Date 2018/6/9 16:20
 */
public class MainTest {

    @Test
    public void testSegmentTree() {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        //老式的写法,匿名内部类
        /*
       SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, new Merger<Integer>() {
            @Override
            public Integer merger(Integer a, Integer b) {
                return a + b;
            }
        });
        */
        //java8的lambda表达式写法
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (a, b) -> a + b);
        System.out.println(segmentTree);

        /*
        最终结果：
        [-3, 1, -4, -2, 3, -3, -1, -2, 0, null, null, -5, 2, null, null, null, null, null, null, null, null, null, null, null]
         */
        /////////////////////////////////////////
        //    [-2, 0, 3, -5, 2, -1] sum:(-3)   //
        //            /  \                     //
        //  (1)[-2,0,3]   [-5,2,-1] sum:(-4)   //
        //       /  \          /  \            //
        // (-2)[-2] [0,3](3)(-3)[-5,2] [-1](-1)//
        //   ..............................    //
        /////////////////////////////////////////

    }

    /**
     * 线段树的查询测试用例
     */
    @Test
    public void testSegmentTreeQuery() {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        //java8的lambda表达式写法,merger传入的是sum
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (a, b) -> a + b);
        // 0-2 的区间线段树值sum = 1
        System.out.println(segmentTree.query(0,2));
        System.out.println(segmentTree.query(2,5));
        System.out.println(segmentTree.query(0,5));
    }
}
