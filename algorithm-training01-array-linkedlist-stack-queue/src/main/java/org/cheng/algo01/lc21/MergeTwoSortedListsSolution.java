package org.cheng.algo01.lc21;

/**
 * 21. 合并两个有序链表
 * 表的所有节点组成的。 
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 * <p>
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *  
 * <p>
 * 提示：
 * <p>
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 * 通过次数597,972提交次数903,984
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 */
public class MergeTwoSortedListsSolution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 保护节点
        ListNode protectNode = new ListNode();
        // 当前移动到的节点
        ListNode current = protectNode;
        // 双指针 p q
        ListNode p = l1;
        ListNode q = l2;
        while (p != null && q != null) {
            if (p.val < q.val) {
                // p 指针位置节点 小于 q指针位置节点 将当前节点下一个位置指向p 然后p向后移动指针，
                // 最后调整当前节点的位置 指向原先的p
                current.next = p;
                p = p.next;
                current = current.next;

            } else {
                current.next = q;
                q = q.next;
                current = current.next;

            }
        }
        if (p != null) {
            current.next = p;
        }
        if (q != null) {
            current.next = q;
        }

        return protectNode.next;

    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

}
