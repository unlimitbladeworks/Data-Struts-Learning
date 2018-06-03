package heap;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName LeetCodeSolution
 * @Description LeetCode 347 题,使用优先队列(自己实现的优先队列)解决：
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 给定数组 [1,1,1,2,2,3] , 和 k = 2，返回 [1,2]。
 * @Date 2018/6/3 15:23
 */
public class LeetCodeSolution {

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
         * 频率越小,优先级越大
         * 目的是让队列中只存频率最大的,频率小的都出队了
         * @param another
         * @return
         */
        @Override
        public int compareTo(Freq another) {
            if (this.freq < another.freq) {
                return 1;
            } else if (this.freq > another.freq) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    /**
     * LeetCode主方法
     * @param nums
     * @param k
     * @return
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
        for (int key : map.keySet()) {
            if (queue.getSize() < k){
                queue.enqueue(new Freq(key,map.get(key)));
            }else if (map.get(key) > queue.getHead().freq){
                queue.dequeue();
                queue.enqueue(new Freq(key,map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        //若队列不为空,则弹出最后剩余队列中的key值
        while (!queue.isEmpty()){
            res.add(queue.dequeue().e);
        }
        return res;
    }

}
