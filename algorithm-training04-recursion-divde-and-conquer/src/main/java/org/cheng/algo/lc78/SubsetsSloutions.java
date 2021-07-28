package org.cheng.algo.lc78;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 */
public class SubsetsSloutions {


    public List<List<Integer>> subsets(int[] nums) {
        // 此题回溯法
        // 当问题需要 "回头"，以此来查找出所有的解的时候，使用回溯算法。
        // 即满足结束条件或者发现不是正确路径的时候(走不通)，要撤销选择，回退到上一个状态，继续尝试，直到找出所有解为止

        //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
        //.怎么样写回溯算法(从上而下，※代表难点，根据题目而变化)
        //①画出递归树，找到状态变量(回溯函数的参数)，这一步非常重要※
        //②根据题意，确立结束条件
        //③找准选择列表(与函数参数相关),与第一步紧密关联※
        //④判断是否需要剪枝
        //⑤作出选择，递归调用，进入下一层
        //⑥撤销选择

        findSubSets(nums,0);

        return ans;

    }

    private void findSubSets(int[] nums, int index) {
        //考虑递归终止条件
        if (index == nums.length) {
            ans.add(new ArrayList<>(set));
            return;
        }
        // 不选,考虑下一步问题
        findSubSets(nums,index + 1);

        // 选，然后再考虑下一步
        set.add(nums[index]);
        findSubSets(nums, index + 1);
        // 还原现场 回溯问题
        set.remove(set.size() - 1);

    }


    /**
     * 开辟全局变量保存答案
     */

    private List<List<Integer>> ans = new ArrayList<>();

    List<Integer> set = new ArrayList<>();
}
