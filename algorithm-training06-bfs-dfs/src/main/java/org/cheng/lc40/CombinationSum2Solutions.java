package org.cheng.lc40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 *
 * 注意：解集不能包含重复的组合。
 *
 *
 *
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 *
 * 提示:
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */
public class CombinationSum2Solutions {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        path = new ArrayList<>();
        ans = new ArrayList<>();
        used = new boolean[candidates.length];
        Arrays.sort(candidates);
        backTracing(candidates,target,0,0);
        return ans;

    }

    private void backTracing(int[] candidates, int target,int sum,int startIndex) {

        if (sum == target) {
            ans.add(new ArrayList<>(path));
        }

        // 这里去重是关键，同一层不能重复元素,同一条路径 可以存在元素重复，怎么判断是同一层的重复元素呢?
        // used[i-1] = false & candidates[i] = candidates[i-1]

        for (int i = startIndex; i < candidates.length && candidates[i] + sum <= target ; i++) {
            if (i > 0 && candidates[i] == candidates[i-1] && !used[i-1]) {
                continue;
            }
            // 选当前元素
            path.add(candidates[i]);
            used[i] = true;
            sum += candidates[i];

            backTracing(candidates, target, sum, i+1);

            sum -= candidates[i];
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

    private List<Integer> path;

    private List<List<Integer>> ans;

    private boolean[] used;
}
