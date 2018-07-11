package com.imooc.queues;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName Array（改版，变为动态数组） 数组篇
 * @Description 慕课实战--数据结构篇 数组的resize复杂度分析,均摊复杂度 以及防止复杂度震荡
 * @Date 2018年4月25日21:55:26
 */
public class Array<E> {

    /**
     * 自定义初始化一个int的数组
     */
    private E[] data;
    /**
     * 在data数组中有效的元素个数
     */
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     *
     * @param capacity
     */
    public Array(int capacity) {
        //不能直接new 泛型,如下
        //data = new E[capacity];
        //只能通过Object来创建进行强转了
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造函数，默认调用构造函数，给10个大小的数组
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组中的元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获得数组的容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向数组最后一位置添加一个元素
     * 时间复杂度: O(1)  因为有一步操作
     *
     * @param e
     */
    public void addLast(E e) {
        //调用add方法即可，size即是最后一位
        add(size, e);
    }

    /**
     * 向数组第一个位置添加元素
     *
     * @param e
     */
    public void addFirst(E e) {
        //同理调用add即可
        add(0, e);
    }

    /**
     * 按照指定index索引位置添加元素
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (size == data.length) {
            resize(2 * data.length);
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("AddLast failed.Require index =>0 and index <= size .");
        }
        for (int i = size - 1; i >= index; i--) {
            //数组最后一位往后移动，插入节点的每一个都往后移动一位
            data[i + 1] = data[i];
        }
        //将插入的索引位置内容替换为e
        data[index] = e;
        //每次将指针往后移动一格
        size++;
    }

    /**
     * 动态数组重构大小
     * 时间复杂度: O(n)
     *
     * @param newCapacity 新容量大小
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 获取index位置的元素
     *
     * @param index
     * @return
     */
    E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    /**
     * 获取数组最后一位的值
     * @return 索引为-1(最后,这里用python的-1来代表了)的值
     */
    E getLast() {
        return get(size - 1);
    }

    /**
     * 获取第一位的元素
     * @return 索引为1的值
     */
    E getFirst() {
        return get(1);
    }

    /**
     * 更新某一索引的字段
     *
     * @param index
     * @param e
     */
    void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        data[index] = e;
    }

    /**
     * 判断是否包含某一元素
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找元素e的索引位置,若存在e则返回，若不存在e则返回-1
     *
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除某一索引的元素
     * 此方法会造成复杂度震荡，例如addLast->removeLast->addLast->removeLast会导致来回resize
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        //将此索引的输出位置返回给用户
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        //如果删除索引时,发生了容量减小,实际空间也要减小,lazy,当数组大小等于总容量的1/4时，在进行缩容
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        size--;
        //loitering objects != memory leak
        data[size] = null;
        return ret;
    }

    /**
     * 删除第一个元素
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个元素
     * 时间复杂度: O(1) ,与addList同理,都是一步操作
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 移除某个元素
     *
     * @param e
     * @return
     */
    public boolean removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }


    /**
     * 重写了toString方法，为了打印方便
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d , capacity = %d %n", size, data.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }
}
