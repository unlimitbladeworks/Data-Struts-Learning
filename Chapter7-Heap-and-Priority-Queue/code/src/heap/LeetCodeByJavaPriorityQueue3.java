package heap;

import org.junit.Test;

import java.util.*;
import java.util.PriorityQueue;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName LeetCodeByJavaPriorityQueue
 * @Description 使用java原生的优先队列(其底层实现是最小堆)实现LeetCode 347 题
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 给定数组 [1,1,1,2,2,3] , 和 k = 2，返回 [1,2]。
 * @Date 2018/6/3 15:58
 */
public class LeetCodeByJavaPriorityQueue3 {

    /**
     * LeetCode主方法
     *
     * @param nums 数组
     * @param k    返回个数
     * @return 返回集合
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        //key:元素,value:频率的次数
        TreeMap<Integer, Integer> map = new TreeMap<>();
        /*
         * 遍历传入的数组，如果包含了值，则对value加一
         * 若没有包含key值,说明是第一次传入,value即为1
         */
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        /**
         * 此处改为匿名内部类,演变过程,使得代码更加简单,先注释掉
         */
        /*
        PriorityQueue<Freq> queue = new PriorityQueue<>(new Comparator<Freq>(){
            @Override
            public int compare(Freq a, Freq b) {
                return a.freq - b.freq;
            }
        });
        */

        /**
         * 使用内名类改变传入的参数类型,此处可以不依赖于Freq,使用map的频率来定义比较
         */
//        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
//            @Override
//            public int compare(Integer a, Integer b) {
//                return map.get(a) - map.get(b);
//            }
//        });


        /**
         * 还可以简化使用java8新特性,使用lambda表达式
         */
        PriorityQueue<Integer> queue = new PriorityQueue<>(
                (a,b) -> map.get(a) - map.get(b)
        );


        //此处和bobo老师的遍历结构不同,阿里推荐遍历map使用EntrySet进行遍历
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            if (queue.size() < k) {
                queue.add(key);
            } else if (map.get(key) > map.get(queue.peek())) {
                queue.remove();
                queue.add(key);
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        //若队列不为空,则弹出最后剩余队列中的key值
        while (!queue.isEmpty()) {
            res.add(queue.remove());
        }
        return res;
    }

    @Test
    public void testPriorityQueue() {
        //频率
        int k = 2;
        int[] array = {1, 1, 1, 2, 2, 3};

        LeetCodeSolution solution = new LeetCodeSolution();
        List<Integer> list = solution.topKFrequent(array, k);
        System.out.println(list);
    }
}
