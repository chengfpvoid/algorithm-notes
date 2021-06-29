package org.cheng.algo.lc23;

/**
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 *
 *
 * 提示：
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 */
public class MergeSortedListsSolution {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode( int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 使用分治法合并
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0) {
            return null;
        }
       return  mergeLists(lists,0,lists.length - 1);

    }

    private ListNode mergeLists(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        //归并左边的
        ListNode l1 = mergeLists(lists,left,mid);


        //归并右边的
        ListNode l2 = mergeLists(lists,mid + 1,right);
        // 两个链表合并
        return mergeTwoLists(l1,l2);
    }

    /**
     * 合并两个有序链表  这题做过
     * @param l1
     * @param l2
     * @return
     */
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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


}
