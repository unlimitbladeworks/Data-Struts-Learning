package com.imooc.set;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName LinkedListSet
 * @Description 基于LinkedList实现的Set
 * @Date 2018/5/20 21:21
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> list;

    public LinkedListSet(){
        list = new LinkedList();
    }

    @Override
    public void add(E e) {
        if (!list.contains(e)){
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
