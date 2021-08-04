package org.cheng.unionset.lc200;

import org.cheng.unionset.DisjointSet;

public class NumIslands {


    public int numIslands(char[][] grid) {

        int m = grid.length;

        int n = grid[0].length;

        // 水域的格子数
        int count = 0;
        DisjointSet disjointSet = new DisjointSet(m * n);

        // 右边和下边两个方向探索
        int[] dx = {1,0};
        int[] dy = {0,1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    count++;
                } else {
                    // grid[i][j] == '1'
                    for (int k = 0; k < 2; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x < m && y < n && grid[x][y] == '1') {
                            disjointSet.unionSet(i*n + j, x*n + y);
                        }

                    }

                }
            }
        }
        return disjointSet.getCount() - count;


    }
}
