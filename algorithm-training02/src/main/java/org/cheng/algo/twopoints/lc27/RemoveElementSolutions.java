package org.cheng.algo.twopoints.lc27;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例
 输入：nums = [3,2,2,3], val = 3
 输出：2, nums = [2,2]
 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。

 你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，
 而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。

 示例 2：

 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 输出：5, nums = [0,1,4,0,3]
 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/remove-element

 */
public class RemoveElementSolutions {
    /**
     * 快慢指针解法 初始同一位置，不等于val的时候 同时移动，等于val时 快指针移动，慢指针不动
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int fastIndex = 0;
        int slowIndex;
        for (slowIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val ) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
            //如果等于value 快指针继续往前走，慢指针不动
        }
        return slowIndex;


    }
    public int removeElement2(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < size; j++) {
                    nums[j-1] = nums[j];
                }
                i--;
                size--;
            }
        }

        return size;

    }



    public static void main(String[] args) {
        int nums[] = {3,4,7,2,2,2,5,2};

        RemoveElementSolutions solutions = new RemoveElementSolutions();
        int size = solutions.removeElement(nums,2);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                stringBuilder.append(nums[i]);

            } else {
                stringBuilder.append(nums[i]).append(",");
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
