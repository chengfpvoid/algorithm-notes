package org.cheng.algo.strings.lc387;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 * 提示：你可以假定该字符串只包含小写字母。
 */
public class UniqueCharSolutions {

    public int firstUniqChar(String s) {
        // 统计词频

        Map<Character,Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }
        // 遍历字符串，找出第一个词频为1的位置 返回
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        // 找不到 返回-1
        return -1;


    }

}
