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
public class LeetCodeByJavaPriorityQueue2 {

    /**
     * 构造一个freq内部类,封装了key-value作为对象属性
     * 目的是:将map的key-value做成freq的类型,作为PriorityQueue<Freq>的泛型。
     */
    private class Freq {
        int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }
    }

    /**
     * 创建比较器
     */
    private class FreqComparator implements Comparator<Freq> {

        /**
         * 谁小,谁先出队
         *
         * @param a
         * @param b
         * @return
         */
        @Override
        public int compare(Freq a, Freq b) {
            return a.freq - b.freq;
        }
    }


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


        PriorityQueue<Freq> queue = new PriorityQueue<>(new FreqComparator());
        //此处和bobo老师的遍历结构不同,阿里推荐遍历map使用EntrySet进行遍历
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            if (queue.size() < k) {
                queue.add(new Freq(key, map.get(key)));
            } else if (map.get(key) > queue.peek().freq) {
                queue.remove();
                queue.add(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        //若队列不为空,则弹出最后剩余队列中的key值
        while (!queue.isEmpty()) {
            res.add(queue.remove().e);
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
