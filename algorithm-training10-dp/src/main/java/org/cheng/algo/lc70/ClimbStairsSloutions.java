package org.cheng.algo.lc70;

import java.util.Arrays;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class ClimbStairsSloutions {

    public int climbStairs(int n) {

        int[] memo = new int[n + 1];
        Arrays.setAll(memo, i -> -1);
        return dfs(n, memo);

    }

    /**
     * 深度优先搜索 + 记忆化
     * @param i
     * @param memo
     * @return
     */
    private int dfs(int i, int[] memo) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        if (memo[i] == -1) {
            memo[i] = dfs(i - 1,memo) + dfs(i - 2, memo);
        }
        return memo[i];

    }
}
