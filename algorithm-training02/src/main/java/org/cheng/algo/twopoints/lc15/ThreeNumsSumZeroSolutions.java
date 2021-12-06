package org.cheng.algo.twopoints.lc15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumsSumZeroSolutions {
    /**
     * 15. 三数之和
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 示例 2：
     *
     * 输入：nums = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：nums = [0]
     * 输出：[]
     *
     *
     * 提示：
     *
     * 0 <= nums.length <= 3000
     * -105 <= nums[i] <= 105
     * @param nums
     * @return
     */

    public List<List<Integer>> threeSum(int[] nums) {

        // 难点 不重复的三元组
        //特判，对于数组长度 nn，如果数组为 nullnull 或者数组长度小于 3，返回 []。
        //对数组进行排序。
        //遍历排序后数组：
        //若 nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 0，直接返回结果。
        //对于重复元素：跳过，避免出现重复解
        //令左指针 L=i+1L=i+1，右指针 R=n-1，当 L<R，执行循环：
        //当 nums[i]+nums[L]+nums[R]==0nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，去除重复解。并同时将 L,RL,R 移到下一位置，寻找新的解
        //若和大于 00，说明 nums[R]nums[R] 太大，RR 左移
        //若和小于 00，说明 nums[L]nums[L] 太小，LL 右移
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3 ) {
            return ans;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                // 排好序的元素 后面都是比0大的了
                return ans;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                // 避免出现重复解 跳过重复元素，因为后面l r区间会考虑到这个元素的
                continue;
            }
            // 双指针
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    ans.add(list);
                    while (l < r && nums[l] == nums[l+1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r-1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }

            }
        }
        return ans;

    }


    private void printListGroup(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            StringBuilder sb = new StringBuilder("[");

            for (int i = 0; i < list.size(); i++) {

                if ( i == list.size() - 1) {
                    sb.append(list.get(i));
                } else {
                    sb.append(list.get(i)).append(",");
                }
            }
            sb.append("]");
            System.out.println(sb.toString());

        }
    }


    public static void main(String[] args) {
        int[] nums = {-1,2,-1,-1,-1,5,2};
        ThreeNumsSumZeroSolutions s = new ThreeNumsSumZeroSolutions();
        s.printListGroup(s.threeSum(nums));
    }
}
