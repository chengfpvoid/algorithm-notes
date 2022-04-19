package org.cheng.algo.lc206;

public class ReverseLinkedListSolution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val,ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        // 当前指针
        ListNode cur = null;
        // 每次改一条边 然后后移一位
        ListNode pre = head;
        while (pre != null) {
            // 后面要改掉 先预存
            ListNode nextPre = pre.next;
            // 改一条边
            pre.next = cur;
            // cur pre后移一位
            cur = pre;
            pre = nextPre;
        }

        return cur;
    }

    /**
     * 递归方法
     * 我子节点下的所有节点都已经反转好了，现在就剩我和我的子节点 没有完成最后的反转了，所以反转一下我和我的子节点。
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 反转之后的链表
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;


    }
}
