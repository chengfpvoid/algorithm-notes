package org.cheng.algo01.stack.lc20.lc155;

import java.util.Stack;

/**
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
public class MinStack {
    /**
     * 维护2 个栈 1个前缀最小值栈，一个普通栈
     */
    private Stack<Integer> stack;

    private Stack<Integer> preMinStack;

    public MinStack() {
        stack = new Stack<>();
        preMinStack = new Stack<>();
    }

    public void push(int val) {
        preMinStack.push(stack.isEmpty() ? val : Math.min(val,preMinStack.peek()));
        stack.push(val);
    }

    public void pop() {
        // 如果普通栈pop的值是最小的，那么最小前缀栈顶部也是一样的值，也pop掉
        preMinStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return preMinStack.peek();

    }
}
