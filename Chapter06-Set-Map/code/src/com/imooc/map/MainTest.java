package com.imooc.map;

import com.imooc.set.FileOperation;
import com.imooc.set.LinkedListSet;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName MainTest
 * @Description Map测试类
 * @Date 2018年05月24日22:41:32
 */
public class MainTest {

    @Test
    public void testLinkedListMap() {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();


        if (FileOperation.readFile("./Data-Struts-Learning/Chapter6-Set-Map/code/src/pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            LinkedListMap<String, Integer> map = new LinkedListMap<>();
            for (String word : words1) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }
            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE : " + map.get("pride"));
        }

    }

    @Test
    public void testBSTMap() {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();


        if (FileOperation.readFile("./Data-Struts-Learning/Chapter6-Set-Map/code/src/pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            BSTMap<String, Integer> map = new BSTMap<>();
            for (String word : words1) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }
            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE : " + map.get("pride"));
        }

    }

    /**
     * 测试LinkedListMap 和 BST 二者间的时间差测试用例
     */
    @Test
    public void testTimeCompare() {
        LinkedListMap<String, Integer> map = new LinkedListMap<>();
        System.out.println("LinkedListMap:" + testMap(map) + "s");
        BSTMap<String, Integer> map2 = new BSTMap<>();
        System.out.println("BST:" + testMap(map2) + "s");
    }

    /**
     * 测试两个Map的时间
     *
     * @return
     */
    private double testMap(Map<String, Integer> map) {

        long startTime = System.nanoTime();

        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();


        if (FileOperation.readFile("./Data-Struts-Learning/Chapter6-Set-Map/code/src/pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            for (String word : words1) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }
            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE : " + map.get("pride"));
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

}
