package heap;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName LeetCodeByJavaPriorityQueue
 * @Description 使用java原生的优先队列(其底层实现是最小堆)实现LeetCode 347 题
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 给定数组 [1,1,1,2,2,3] , 和 k = 2，返回 [1,2]。
 * @Date 2018/6/3 15:58
 */
public class LeetCodeByJavaPriorityQueue {

    /**
     * 构造一个freq内部类,封装了key-value作为对象属性
     * 目的是:将map的key-value做成freq的类型,作为PriorityQueue<Freq>的泛型。
     * 注: 类中需要实现可比较接口,因为PriorityQueue需要可比性
     */
    private class Freq implements Comparable<Freq> {
        int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        /**
         * java原生的优先队列(其底层实现是最小堆)
         * 所以比较的逻辑需要变更:
         * 如果当前的频率小于传入的频率,返回-1，大于,返回1,
         * 此处逻辑与最大堆的实现相反....
         * @param another
         * @return
         */
        @Override
        public int compareTo(Freq another) {
            if (this.freq < another.freq) {
                return -1;
            } else if (this.freq > another.freq) {
                return 1;
            } else {
                return 0;
            }
        }
    }


    /**
     * LeetCode主方法
     * @param nums 数组
     * @param k 返回个数
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


        PriorityQueue<Freq> queue = new PriorityQueue<>();
        //此处和bobo老师的遍历结构不同,阿里推荐遍历map使用EntrySet进行遍历
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            if (queue.size() < k){
                queue.add(new Freq(key,map.get(key)));
            }else if (map.get(key) > queue.peek().freq){
                queue.remove();
                queue.add(new Freq(key,map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        //若队列不为空,则弹出最后剩余队列中的key值
        while (!queue.isEmpty()){
            res.add(queue.remove().e);
        }
        return res;
    }

    @Test
    public void testPriorityQueue(){
        //频率
        int k = 2;
        int[] array = {1,1,1,2,2,3};

        LeetCodeSolution solution = new LeetCodeSolution();
        List<Integer> list = solution.topKFrequent(array,k);
        System.out.println(list);
    }
}
