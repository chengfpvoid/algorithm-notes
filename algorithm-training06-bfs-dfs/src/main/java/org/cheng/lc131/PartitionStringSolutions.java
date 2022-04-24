package org.cheng.lc131;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 */
public class PartitionStringSolutions {

    /**
     * 示例 1：
     *
     * 输入：s = "aab"
     * 输出：[["a","a","b"],["aa","b"]]
     * 示例 2：
     *
     * 输入：s = "a"
     * 输出：[["a"]]
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        path = new ArrayList<>();
        ans = new ArrayList<>();
        backTracing(s,0);
        return ans;
    }

    private void backTracing(String s, int startIndex) {
        // 如果起始位置大于s的大小，说明找到一个分割方案
        if (startIndex >= s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (!isPalindrome(s,startIndex,i)) {
                continue;
            }
            String str = s.substring(startIndex,i + 1);
            path.add(str);
            backTracing(s,i+1);
            path.remove(path.size() - 1);
        }

    }


    private boolean isPalindrome(String s, int startIndex, int endIndex) {
        for(int i = startIndex, j = endIndex; i < j; i++,j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    private List<String> path;

    private List<List<String>> ans;


}
