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

class Solution {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode mid = findMiddle(head);
        ListNode linkedlist2 = mid.next;
        mid.next = null;// 断开linkedlist
        ListNode head2 = reverse(linkedlist2);

        merge(head, head2);

    }
    // step one: find the middle 
    private ListNode findMiddle (ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    // step two: reverse the second half linkedlist
    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode prev = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    // step three: merge the linkedlist1 and linkedlist2
    private ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (head1 != null && head2 != null) {
            cur.next = head1;
            head1 = head1.next;
            cur = cur.next;

            cur.next = head2;
            head2 = head2.next;
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
