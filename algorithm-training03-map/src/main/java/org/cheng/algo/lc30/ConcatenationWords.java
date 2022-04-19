package org.cheng.algo.lc30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 *
 * 输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * 输出：[]
 * 示例 3：
 *
 * 输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * 输出：[6,9,12]
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 30
 * words[i] 由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 */
public class ConcatenationWords {

    public List<Integer> findSubstring(String s, String[] words) {
        // s的子串怎么判断是否是words的串联?
        // words每个单词长度相同,计算出总长度,每次拿出总长度个字符比较
        // 先对words每个单词做map,再比较每个总长度单元得到的map 是否相同，相同就把起始位置加入
        int oneWordLength = words[0].length();
        int wordsLength = words.length;
        int length = oneWordLength * wordsLength;

        Map<String,Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word,map.getOrDefault(word,0) + 1);
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0 ; i < s.length() - length + 1; i++) {
            Map<String,Integer> sMap = new HashMap<>();
            for (int j = i; j < i + length; j += oneWordLength) {

                String subStr = s.substring(j,j + oneWordLength);
                sMap.put(subStr,sMap.getOrDefault(subStr,0) + 1);
            }
            if (sMap.equals(map)) {
                ans.add(i);
            }

        }
        return ans;


    }


    /**
     * 串联所有单词的子串
     * 滑动窗口 + map
     * @param s 字符串
     * @param words 单词数组
     * @return 串联所有单词的子串
     */
    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        // words中每个单词出现的次数
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            if (!s.contains(word)) {
                // 没有当前单词，直接返回
                return result;
            }
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }

        // 一个单词的长度
        int oneLen = words[0].length();
        // 需要搜索的总长度，即滑动窗口的大小
        int wordsLen = oneLen * words.length;
        if (s.length() < wordsLen) {
            // 主串长度小于搜索长度，直接返回
            return result;
        }

        // 只讨论从0,1...,oneLen-1开始的子串情况
        // 每次进行匹配的窗口大小为wordsLen，每次右移oneLen长度
        // 这样就能覆盖从所有位置开始的窗口
        for (int i = 0; i < oneLen; ++i) {
            int left = i;
            // 因为要使用substring，所以right最大可以达到s.length()
            int right = i;
            // 子串中单词出现的次数
            Map<String, Integer> subMap = new HashMap<>();
            // 右指针不能超过主串长度
            while (right + oneLen <= s.length()) {
                // 得到当前单词
                String word = s.substring(right, right + oneLen);
                // 右指针右移
                right += oneLen;
                // words中没有这个单词，当前窗口匹配失败，直接右移到这个单词后面重新匹配
                if (!wordsMap.containsKey(word)) {
                    left = right;
                    // 清空subMap，为重新匹配做准备
                    subMap.clear();
                } else {
                    // 当前单词出现的次数加1
                    subMap.put(word, subMap.getOrDefault(word, 0) + 1);
                    while (subMap.get(word) > wordsMap.get(word)) {
                        // 从子串map中删除最左侧单词，直至word次数不大于需要的次数
                        String del = s.substring(left, left + oneLen);
                        // 最左的单词肯定在子串map里，所以可以直接减1
                        subMap.put(del, subMap.get(del) - 1);
                        // 左指针右移一个单词
                        left += oneLen;
                    }
                    if (subMap.equals(wordsMap)) {
                        result.add(left);
                    }
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {

        new ConcatenationWords().findSubstring2("foobarthefoobarfoo",new String[]{"the","foo","bar"});

    }


}
