package trie;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName Set
 * @Description 自定义集合的接口
 * @Date 2018/5/18 22:58
 */
public interface Set<E> {

    /**
     * 添加元素
     * @param e
     */
    void add(E e);

    /**
     * 删除元素
     * @param e
     */
    void remove(E e);

    /**
     * 是否包含元素
     * @param e
     * @return
     */
    boolean contains(E e);

    /**
     * 获取集合大小
     * @return
     */
    int getSize();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();

}
