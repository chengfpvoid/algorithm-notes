package org.cheng.algo.lc560;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 *
 */
public class SubarraySumSolution {

    public int subarraySum(int[] nums, int k) {
        // 统计前缀和
        int prefixSum = 0;
        Map<Integer,Integer> prefixSumCountMap = new HashMap<>();
        // 第0个元素之前的前缀和 设为0  出现1次
        prefixSumCountMap.put(0,1);

        int ans = 0;
        // 区间 [i,j]的和是k 是前缀和prefixSum[j] - prefixSum[i-1]的值是k
        // 即考虑右端点 j 统计 i <= j 前提下  前缀和是 prefixSum[j] - k  出现的次数
        for(int j = 0; j < nums.length; j++) {
            // 计算prefixSum[j]
            prefixSum += nums[j];
            if (prefixSumCountMap.containsKey(prefixSum - k)) {
                ans += prefixSumCountMap.get(prefixSum - k);
            }
            prefixSumCountMap.put(prefixSum,prefixSumCountMap.getOrDefault(prefixSum,0) + 1);
        }
        return ans;


    }
}
