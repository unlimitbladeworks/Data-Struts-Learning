package uf;
/**
 * @author suyu
 * @version 1.0.0
 * @ClassName UF
 * @Description UnionFind 并查集的规范接口
 * @Date 2018年07月11日10:37:55
 */
public interface UF {

    /**
     * 获取大小容量
     * @return 大小
     */
    int getSize();

    /**
     * 查操作,查看两个元素是否属于一个集合,是否连接
     * @param p 参数1
     * @param q 参数2
     * @return 是否连接
     */
    boolean isConnected(int p,int q);

    /**
     * 并 ∪ 操作, 将两个元素并在一起
     * @param p 参数1
     * @param q 参数2
     */
    void unionElements(int p,int q);
}
