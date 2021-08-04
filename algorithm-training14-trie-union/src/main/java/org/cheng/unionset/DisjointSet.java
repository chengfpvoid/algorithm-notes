package org.cheng.unionset;

/**
 * 并查集 模板
 */
public class DisjointSet {

    private int fa[];
    // 并查集的个数
    private  int count;

    public DisjointSet(int n) {
        // n个元素的并查集 初始化,fa[i] 相同的 位置 在同一个并查集下面
        fa = new int[n];
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
        count = n;
    }

    /**
     * 查找x位置 并查集的根位置
     * @param x
     * @return
     */
    public int find(int x) {
        if ( x == fa[x]) {
            return x;
        }
        fa[x] = find(fa[x]);
        return fa[x];
    }

    /**
     * 合并元素
     * @param x
     * @param y
     */
    public void unionSet(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            fa[x] = y;
            // 发生合并 count-1
            count--;
        }

    }


    public int getCount() {
        return this.count;
    }
}
