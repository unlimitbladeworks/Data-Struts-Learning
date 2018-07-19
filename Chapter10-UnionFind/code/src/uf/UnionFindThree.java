package uf;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName UnionFindThree
 * @Description 并查集第三版
 * @Date 2018年07月19日22:20:56
 */
public class UnionFindThree implements UF {

    private int[] parent;

    /**
     * sz[i]表示以i为根的集合中元素个数
     */
    private int[] sz;

    public UnionFindThree(int size) {
        parent = new int[size];
        sz = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }


    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 查找过程,查找元素p对应的集合编号
     * O(h)复杂度,h为树的高度
     *
     * @param p
     * @return
     */
    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound");
        }
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    /**
     * 查看p和q是否属于同一集合
     * O(h)复杂度,h为树的高度
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
     * 合并元素p,q 所属的集合
     * O(h)复杂度,h为树的高度
     *
     * @param p 参数1
     * @param q 参数2
     */
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        if (sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else { //sz[qRoot] <= sz[pRoot]
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }
}
