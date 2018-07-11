package segment.tree;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName Merger
 * @Description 融合器
 * @Date 2018/6/9 16:14
 */
public interface Merger<E> {
    /**
     * 创建一个接口,给客户端用户程序员定义：
     *  定义融合法则,是将线段树进行增加操作,还是别的操作
     * @param a
     * @param b
     * @return
     */
    E merger(E a, E b);
}
