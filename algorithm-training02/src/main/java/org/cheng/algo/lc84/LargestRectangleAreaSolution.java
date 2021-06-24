package org.cheng.algo.lc84;

import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 *
 *
 *
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 *
 *
 *
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 *
 *
 * 示例:
 *
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 */
public class LargestRectangleAreaSolution {

    public int largestRectangleArea(int[] heights) {
        Stack<Rect> stack = new Stack<>();
        int ans = 0;
        // 这里要压一个最小元素 帮助出栈 这里不加，最后元素比栈里面的都大，那最终什么也没计算
        int[] newHeights = new int[heights.length + 1];
        System.arraycopy(heights,0,newHeights,0,heights.length);

        for(int i = 0; i < newHeights.length; i++) {
            int accumulatedWidth = 0;
            while(!stack.isEmpty() && stack.peek().height >= newHeights[i]) {
                accumulatedWidth += stack.peek().width;
                ans = Math.max(ans,accumulatedWidth * stack.peek().height);
                stack.pop();
            }
            stack.push(new Rect(newHeights[i],accumulatedWidth + 1));
        }
        stack.clear();

        return ans;

    }

    private static class Rect {
        int height;
        int width;

        public Rect(int height, int width) {
            this.height = height;
            this.width = width;
        }
    }




}
