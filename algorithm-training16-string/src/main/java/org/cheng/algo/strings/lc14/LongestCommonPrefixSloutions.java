package org.cheng.algo.strings.lc14;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 *
 * 提示：
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 */
public class LongestCommonPrefixSloutions {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // n个字符串 找到最小长度
        int minLen = Integer.MAX_VALUE;
        for (String s : strs) {
            minLen = Math.min(minLen,s.length());
        }
        // 将第一个字符串作为最长公共前缀初始值 与后面的字符串比较，
        // 找到当前的最长公共前缀，再继续与后面的比较，每个字符串只要比较到最小的长度
        String ans = strs[0];
        for ( int i = 1; i < strs.length; i++) {
            int j = 0;
            while (j < minLen && j < ans.length()) {
                if (ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
                j++;
            }
            ans = ans.substring(0,j);
            if (ans.isEmpty()) {
                return "";
            }

        }
        return ans;

    }


}
