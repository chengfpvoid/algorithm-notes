package org.cheng.lc39;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
 * <p>
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * 示例 2：
 * <p>
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3：
 * <p>
 * 输入: candidates = [2], target = 1
 * 输出: []
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都 互不相同
 * 1 <= target <= 500
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 */
public class CombinationSumSolutions {

    /**
     * * 示例 1：
     * *
     * * 输入：candidates = [2,3,6,7], target = 7
     * * 输出：[[2,2,3],[7]]
     * * 解释：
     * * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
     * * 7 也是一个候选， 7 = 7 。
     * * 仅有这两种组合。
     * * 示例 2：
     * *
     * * 输入: candidates = [2,3,5], target = 8
     * * 输出: [[2,2,2,2],[2,3,3],[3,5]]
     * * 示例 3：
     * *
     * * 输入: candidates = [2], target = 1
     * * 输出: []
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        path = new ArrayList<>();

        backTracing(candidates,target,0);

        return result;


    }

    private List<List<Integer>> result;

    private  List<Integer> path;

    private  int sum = 0;
    private void backTracing(int[] candidates, int target, int index) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        // int i = index; i < candidates.length; i++
        for (int i = index; i < candidates.length; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            // 不用i+1 表示可以重复
            backTracing(candidates, target, i);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }

    /**
     * 采用剪枝的策略，发现循环时发现sum > target就不向下遍历了
     * 其实如果已经知道下一层的sum会大于target，就没有必要进入下一层递归了。
     * @param candidates
     * @param target
     * @param index
     */
    private void backTracing2(int[] candidates, int target, int index) {

        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        // int i = index; i < candidates.length; i++
        for (int i = index; i < candidates.length && sum + candidates[i] <= target ; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            // 不用i+1 表示可以重复
            backTracing(candidates, target, i);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }


}
