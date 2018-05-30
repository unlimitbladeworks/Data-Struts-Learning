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
}
