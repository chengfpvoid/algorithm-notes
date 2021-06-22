package org.cheng.algo01.lc66;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 *
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 *
 * 输入：digits = [0]
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 */
public class PlusOneSolution {


    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if(digits[i] != 9){
                // 最后一位不是9 则最后一位+1后返回
                // 最后一位是9 继续往前看 找到不是9的那一位 + 1 把前面是9的 都变成0 譬如 7,8,9 最后一位是9 9变成0，
                // 倒数第二位8 不是9 ，+1后变成7,9,0直接返回
                digits[i]++;
                return digits;
            }
            // 从最后一位开始的9 逐一都变成0
            digits[i] = 0 ;
        }
        // 到这里还没返回 说明都是9...9 则进一位 10....
        digits = new int[n + 1];
        digits[0] = 1;

        return digits;

    }

}
