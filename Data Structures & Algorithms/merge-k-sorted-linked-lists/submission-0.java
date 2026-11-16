/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// 用的是mergesort 来解这道题
// 每一轮里，每个节点只属于一对 merge，所以每轮所有节点加起来只碰一次，O(N)
// 每一轮条数减半：k → k/2 → k/4 → … → 1，一共 log k 轮, time complexity O(N log k)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }
    // step one: 找中点
    private ListNode merge (ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode head1 = merge(lists, left, mid);
        ListNode head2 = merge(lists, mid + 1, right);

        return mergeTwoList(head1, head2);
    }
    // Step two: 把list 1 and list2 两两merge
    private ListNode mergeTwoList(ListNode head1, ListNode head2) {
        if(head1 == null && head2 == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2= head2.next;
            }
            cur = cur.next;
        }
        if (head1 != null) {
            cur.next = head1;
        } else {
            cur.next = head2;
        }
        return dummy.next;
    }
}
