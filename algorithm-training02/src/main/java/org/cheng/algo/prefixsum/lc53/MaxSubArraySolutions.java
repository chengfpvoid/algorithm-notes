package org.cheng.algo.prefixsum.lc53;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：0
 * 示例 4：
 *
 * 输入：nums = [-1]
 * 输出：-1
 * 示例 5：
 *
 * 输入：nums = [-100000]
 * 输出：-100000
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 *
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 */
public class MaxSubArraySolutions {
    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *  * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     *  * 输出：6
     *  * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        // 求区间和 的最大值
        // 区间和 先求前缀和
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        // 求前缀和的前缀最小值
        int[] prefixSumMin = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = Math.min(prefixSum[i-1],prefixSum[i]);

        }
        // 区间和 s[i] - s[j]  j <= i-1 最大值，对于每个s[i] 要知道 0 到i -1 范围内的前缀和最小值
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans,prefixSum[i] - prefixSumMin[i-1]);
        }
        return ans;


    }

    /**
     * 贪心算法，和是正的 则向右扩展，发现和是负的 就丢弃前面的,每次扩张 都记录一个比较大的数
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            ans = Math.max(ans,sum);
            if (sum < 0) {
                // 前面的累加数据都被丢弃 给个0
                sum = 0;
            }
        }
        return ans;


    }
}
