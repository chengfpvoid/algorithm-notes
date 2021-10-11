package org.cheng.algo01.lc283;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class MoveZeroesSolution {

    public void moveZeroes(int[] nums) {

        int n = 0;
        // 主题思路：保留非零值
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[n] = nums[i];
                n++;
            }
        }
        // 按题目要求，最后面填充零
        while (n < nums.length) {
            nums[n] = 0;
            n++;
        }


    }

}
