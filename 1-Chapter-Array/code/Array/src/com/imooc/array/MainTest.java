package com.imooc.array;

import org.junit.Test;

/**
 * @ClassName MainTest
 * @Description 测试类
 * @author suyu
 * @Date 2018/4/22 12:53
 * @version 1.0.0
 */
public class MainTest {

    @Test
    public void testArray() {
        int arrayLength = 10;
        Array array = new Array(20);
        for (int i = 0; i < arrayLength; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        array.add(2,100);
        System.out.println(array);

        array.addFirst(12);
        System.out.println(array);

        array.remove(2);
        System.out.println(array);

        array.removeElement(5);
        System.out.println(array);

    }

    @Test
    public void testArrayT() {
        int arrayLength = 10;
        //泛型不能包含基本类型,若想使用必须使用包装类
        ArrayT<Integer> array = new ArrayT<>(20);
        for (int i = 0; i < arrayLength; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        array.add(2,100);
        System.out.println(array);

        array.addFirst(12);
        System.out.println(array);

        array.remove(2);
        System.out.println(array);

        array.removeElement(5);
        System.out.println(array);
    }

    @Test
    public void testArrayDyn() {
        int arrayLength = 10;
        //泛型不能包含基本类型,若想使用必须使用包装类
        ArrayDyn<Integer> array = new ArrayDyn<>();
        for (int i = 0; i < arrayLength; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        array.add(2,100);
        System.out.println(array);

        array.addFirst(12);
        System.out.println(array);

//        array.remove(2);
//        System.out.println(array);
//
//        array.removeElement(5);
//        System.out.println(array);
    }
}
