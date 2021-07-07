package org.cheng.lc130;

/**
 * 130. 被围绕的区域
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 *
 * 示例 1：
 *
 *
 * 输入：board =
 * [["X","X","X","X"],
 *  ["X","O","O","X"],
 *  ["X","X","O","X"],
 *  ["X","O","X","X"]]
 * 输出：
 * [["X","X","X","X"],
 *  ["X","X","X","X"],
 *  ["X","X","X","X"],
 *  ["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * 示例 2：
 *
 * 输入：board = [["X"]]
 * 输出：[["X"]]
 */
public class OBoardSolutions {
    /**
     * 从边界上的O去DFS探索 O ,被访问过的O都是无法被X填充的，反之都是可以被X填充的
     * 将被探索过的O都标记为V表示已访问。最终填充时将剩下的O变为X,V还原成O
     * @param board
     */
    public void solve(char[][] board) {
        // n行 m列
         n = board.length;
        if ( n == 0) {
            return;
        }
        m = board[0].length;
        // 从四个边界点DFS
        for (int i = 0; i < n; i++) {
            dfs(board,i,0);
            dfs(board,i,m - 1);


        }
        for ( int i = 1; i < m; i++) {
            dfs(board,0,i);
            dfs(board,n-1,i);
        }
        // 搜索完以后进行填充
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'V') {
                    board[i][j] = 'O';
                }else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] == 'X' || board[x][y] == 'V') {
            return;
        }
        board[x][y] = 'V';
        for (int i = 0 ; i < 4; i++) {
            dfs(board, x + dx[i], y + dy[i]);
        }
    }

    private int n;
    private int m;
    private int[] dx = {-1,0,1,0};
    private int[] dy = {0,-1,0,1};
}
