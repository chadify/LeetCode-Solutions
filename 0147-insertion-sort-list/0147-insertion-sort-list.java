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
    public ListNode insertionSortList(ListNode head) {

        ListNode dummy = new ListNode(0, head);
        ListNode prev = head, cur = head.next;

        while (cur != null) {
            if (cur.val >= prev.val) {
                prev = cur;
                cur = cur.next;
                continue;
            }

            ListNode tmp = dummy;
            while (cur.val > tmp.next.val)
                tmp = tmp.next;
            
            prev.next = cur.next;
            cur.next = tmp.next;
            tmp.next = cur;
            cur = prev.next;
        }

        return dummy.next;
    }
}