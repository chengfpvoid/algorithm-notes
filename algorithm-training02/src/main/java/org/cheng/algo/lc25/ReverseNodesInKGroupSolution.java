package org.cheng.algo.lc25;

/**
 * 25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 进阶：
 *
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * 示例 2：
 *
 *
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 * 示例 3：
 *
 * 输入：head = [1,2,3,4,5], k = 1
 * 输出：[1,2,3,4,5]
 * 示例 4：
 *
 * 输入：head = [1], k = 1
 * 输出：[1]
 * 提示：
 *
 * 列表中节点的数量在范围 sz 内
 * 1 <= sz <= 5000
 * 0 <= Node.val <= 1000
 * 1 <= k <= sz
 * 通过次数235,492提交次数358,002
 */
public class ReverseNodesInKGroupSolution {

    static class ListNode {
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

    public ListNode reverseGroup(ListNode head, int k) {
        // 分组 （找到每组的开始，结尾） 按组遍历
        // 找到结尾 按组遍历
        // 主体思路看中间，中间是一般情况 头尾是细节 是边界
        // 维护上一组的head
        ListNode protect = new ListNode(0,head);
        ListNode last = protect;
        while (head != null) {
            //开头是head 找到每组的结尾
            ListNode end = getEnd(head,k);
            ListNode nextGroupHead = end.next;
            // 翻转组内的链表 k - 1条边
            // 翻转之后 end.next边被改变了，需要提前保存
            reverseList(head,end);
            // 上一组的新last（旧head） 指向 当前组的新head(旧的end)
            last.next = end;
            // 本组的新结尾(head的位置) 与下一组的head建立联系
            head.next = nextGroupHead;
            //分组遍历 到下一组
            last = head;
            head = nextGroupHead;

        }
        return protect.next;

    }

    private void reverseList(ListNode head, ListNode end) {
        if (head == end) {
            return;
        }
        ListNode last = head;
        head = head.next;
        while (head != end) {
            ListNode nextHead = head.next;
            head.next = last;
            last = head;
            head = nextHead;
        }
        end.next = last;
    }

    /**
     * 找到本组 的最后一个节点
     * @param head 本组的开头
     * @param k 本组的步长
     * @return
     */
    private ListNode getEnd(ListNode head, int k) {
        while (head != null) {
            k--;
            if (k == 0) {
                break;
            }
            head = head.next;
        }
        return head;

    }
}
