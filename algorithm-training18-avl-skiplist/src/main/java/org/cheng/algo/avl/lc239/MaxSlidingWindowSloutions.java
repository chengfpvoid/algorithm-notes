package org.cheng.algo.avl.lc239;

import java.util.TreeMap;

/**
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 *
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 示例 3：
 *
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * 示例 4：
 *
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * 示例 5：
 *
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
public class MaxSlidingWindowSloutions {


    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] ans = new int[n - k + 1];
        TreeMap<Integer, Integer> orderMap = new TreeMap<>();

        for (int i = 0; i < k; i++) {
            // key是值，value是nums[i] 出现的次数
            orderMap.put(nums[i],orderMap.getOrDefault(nums[i],0) + 1);
        }
        // 拿出最大的key
        ans[0] = orderMap.lastKey();

        for(int i = 0; i  < n - k; ++i) {
            // 前面出现过的值，数目 - 1，只出现过1次的，直接移除
            if((orderMap.get(nums[i])) > 1) {
                orderMap.put(nums[i], orderMap.get(nums[i]) - 1);
            } else {
                orderMap.remove(nums[i]);
            }
            // 前面已经有0-k的值统计了，从第k个开始统计
            orderMap.put(nums[i + k],orderMap.getOrDefault(nums[i+k],0) + 1);
            ans[i + 1] = orderMap.lastKey();
        }
        return ans;


    }



    /**
     * 暴力循环 超出乐时间限制
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        int m = n - k + 1;
        int[] ans = new int[m];
        for(int i = 0; i < m ; i++) {

            int max = nums[i];
            int j = i + 1;
            while ( j < i + k) {
                if (nums[j] > max) {
                    max = nums[j];
                }
                j++;
            }
            ans[i] = max;


        }
        return ans;

    }

}
