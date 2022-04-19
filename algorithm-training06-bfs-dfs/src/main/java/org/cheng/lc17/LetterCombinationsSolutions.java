package org.cheng.lc17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * <p>
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 */
public class LetterCombinationsSolutions {

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        initDigitsMap();
        backTracing(digits, 0);
        return ans;


    }

    private void backTracing(String digits, int index) {
        if (digits.length()  == index) {
            ans.add(path.toString());
            return;
        }
        String str = digitsMap.get(String.valueOf(digits.charAt(index)));
        for (int i = 0; i < str.length(); i++) {
            path.append(str.charAt(i));
            backTracing(digits, index + 1);
            path.deleteCharAt(path.length() - 1);
        }

    }

    private Map<String, String> digitsMap = new HashMap<>();

    private List<String> ans = new ArrayList<>();

    private StringBuilder path = new StringBuilder("");

    private void initDigitsMap() {
        digitsMap.put("1", "");
        digitsMap.put("2", "abc");
        digitsMap.put("3", "def");
        digitsMap.put("4", "ghi");
        digitsMap.put("5", "jkl");
        digitsMap.put("6", "mno");
        digitsMap.put("7", "pqrs");
        digitsMap.put("8", "tuv");
        digitsMap.put("9", "wxyz");
    }

    public static void main(String[] args) {
        LetterCombinationsSolutions  solutions = new LetterCombinationsSolutions();
        List<String> list = solutions.letterCombinations("23");
        list.forEach(System.out::println);
    }
}
