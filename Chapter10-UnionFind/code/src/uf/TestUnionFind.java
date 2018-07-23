package uf;

import java.awt.*;
import java.util.Random;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName TestUnionFind
 * @Description 测试两种UnionFind效率
 * @Date 2018年07月19日22:09:49
 */
public class TestUnionFind {

    /**
     * 测试uf实现类的效率方法
     *
     * @param uf 实现类
     * @param m
     * @return 时间
     */
    public static double testUF(UF uf, int m) {
        int size = uf.getSize();
        Random random = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a,b);
        }

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a,b);
        }


        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;

    }

    public static void main(String[] args) {

        int size = 100000;
        int m = 100000;

        /**先注释掉两个慢的
        UnionFindOne unionFindOne = new UnionFindOne(size);
        System.out.println("UnionFind1 : " +  testUF(unionFindOne,m) + " s");

        UnionFindTwo unionFindTwo = new UnionFindTwo(size);
        System.out.println("UnionFind2 : " +  testUF(unionFindTwo,m) + " s");
        */
        UnionFindThree unionFindThree = new UnionFindThree(size);
        System.out.println("UnionFind3 : " +  testUF(unionFindThree,m) + " s");

        UnionFindFour unionFindFour = new UnionFindFour(size);
        System.out.println("UnionFind4 : " +  testUF(unionFindFour,m) + " s");

        UnionFindFive unionFindFive = new UnionFindFive(size);
        System.out.println("UnionFind5 : " +  testUF(unionFindFive,m) + " s");

    }
}
