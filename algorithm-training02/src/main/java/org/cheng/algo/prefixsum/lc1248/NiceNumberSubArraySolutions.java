package org.cheng.algo.prefixsum.lc1248;

/**
 * 1248. 统计「优美子数组」
 * 给你一个整数数组 nums 和一个整数 k。
 *
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 *
 * 请返回这个数组中「优美子数组」的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * 示例 2：
 *
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 * 示例 3：
 *
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 */
public class NiceNumberSubArraySolutions {

    public int numberOfSubArrays(int[] nums, int k) {
        // 题目问 多少个连续子数组 有k个奇数
        // 让奇数映射成1，偶数映射成0 题目变为 多少个 子数组的和为k
        // 求子段和 s(l,r) = s[r] - s[l-1] = k
        // for  r = 1 - n
        //   for l = l - r
        //     if s[r] - s[l - 1] = k
        //            ans += 1;
        // r (1 - n) 考虑有几个l (1 -r ) 使得 s[r] - s[l - 1] = k
        // 固定外层循环变量，考虑内层满足什么条件
        // 对于每个i 考虑几个j (0 - i-1) 使得 s[i] - s[j] = k  =>  s[j] = s[i] - k
        // 计数count 在一个数组s中统计等于某个数的数量
        // 下标变成 1 - n
        int n = nums.length;
        int[] s = new int[n + 1];
        int[] count = new int[n + 1];
        s[0] = 0;
        count[s[0]] = 1;

        for (int i = 1; i <= n; i++) {
            s[i] = s[i-1] + nums[i - 1] % 2;
            count[s[i]]++;

        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (s[i] - k >= 0) {
                ans += count[s[i] - k];
            }
        }

        return ans;

    }


}
