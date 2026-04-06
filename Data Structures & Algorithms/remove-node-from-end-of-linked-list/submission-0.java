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

    // 5
    // d -> 5 -> null
    // l          r
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);

        ListNode l = dummy;


        ListNode r = head;
        while (n > 0) {
            r = r.next;
            n--;
        }

        while (r != null) {
            r = r.next;
            l = l.next;
        }

        // remove l.next
        l.next = l.next.next;

        return dummy.next;

    }
}
