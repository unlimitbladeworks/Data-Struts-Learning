package uf;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName UnionFindOne
 * @Description 并查集第一版(Quick find)
 * Quick Find:
 * isConnected(p,q):O(1)
 * unionElements(p,q):O(n)
 * @Date 2018/7/15 9:43
 */
public class UnionFindOne implements UF {

    /**
     * 并查集的元素对应的id值
     */
    private int[] id;

    public UnionFindOne(int size) {
        id = new int[size];
        //每一个元素对应的id编号不一样,每个元素属于不同的集合
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    /**
     * 查找元素p对应的集合编号
     *
     * @param p 元素p
     * @return
     */
    private int find(int p) {
        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException("p is out of bound");
        }

        return id[p];
    }

    /**
     * 查看p和q是否属于同一集合
     *
     * @param p 参数1
     * @param q 参数2
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并元素p，q 所属的集合
     *
     * @param p 参数1
     * @param q 参数2
     */
    @Override
    public void unionElements(int p, int q) {

        int pID = find(p);
        int qID = find(q);

        if (pID == qID) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
    }
}
