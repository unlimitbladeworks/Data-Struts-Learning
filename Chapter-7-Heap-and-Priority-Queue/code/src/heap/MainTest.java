package heap;

import org.junit.Test;

import java.util.Random;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName MainTest
 * @Description MaxHeap's Junit Test
 * @Date 2018年05月30日23:02:59
 */
public class MainTest {

    @Test
    public void testMaxHeap() {
        int n = 10000000;
        MaxHeap<Integer> heap = new MaxHeap<>();

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            heap.add(random.nextInt(Integer.MAX_VALUE));
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = heap.extractMax();
        }
        /*
         * arr中应该是从大到小排序.
         * 如果索引前一个元素小于后一个元素的值,则抛出异常！
         */
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("Error!");
            }
        }
        System.out.println("Test MaxHeap completed!");
    }


    /**
     * 测试 Heapify 和 add 二者时间
     * Heapify 时间复杂度: O(logn)
     *
     * @param testData
     * @param isHeapify
     * @return
     */
    private static double testHeap(Integer[] testData, boolean isHeapify) {

        long startTime = System.nanoTime();
        MaxHeap<Integer> maxHeap;
        if (isHeapify) {
            maxHeap = new MaxHeap<>(testData);
        } else {
            maxHeap = new MaxHeap<>();
            for (int num : testData) {
                maxHeap.add(num);
            }
        }

        int[] arr = new int[testData.length];
        for (int i = 0; i < testData.length; i++) {
            arr[i] = maxHeap.extractMax();
        }
        /*
         * arr中应该是从大到小排序.
         * 如果索引前一个元素小于后一个元素的值,则抛出异常！
         */
        for (int i = 1; i < testData.length; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("Error!");
            }
        }
        System.out.println("Test MaxHeap completed!");


        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    /**
     * 测试 Heapify 和 add 二者时间
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = 1000000;
        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }
        double time1 = testHeap(testData, false);
        System.out.println("Without heapify: " + time1 + "s");

        double time2 = testHeap(testData, true);
        System.out.println("With heapify: " + time2 + "s");
    }
}
