package org.cheng.algo.lc49;

import java.util.*;

public class GroupAnagrams {

    /**
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     *
     * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * 示例 2:
     *
     * 输入: strs = [""]
     * 输出: [[""]]
     * 示例 3:
     *
     * 输入: strs = ["a"]
     * 输出: [["a"]]
     *  
     *
     * 提示：
     *
     * 1 <= strs.length <= 104
     * 0 <= strs[i].length <= 100
     * strs[i] 仅包含小写字母
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/group-anagrams
     * @param strs
     * @return
     */
    public  List<List<String>> groupAnagrams(String[] strs) {
        // 字母个数相同 字母字符相同
        // 存入hash
        Map<String,List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List l = map.getOrDefault(key,new ArrayList<>());
            l.add(s);
            map.put(key,l);

        }

        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<String,List<String>> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] strs = new String[] {"eat","tea","tan","ate","nat","bat"};
        new GroupAnagrams().groupAnagrams(strs);
    }


}
