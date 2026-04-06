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

    // 3 -> 2 -> 4 -> 5 -> null
    // n = 2
    //                      head n = 2
    //.                head      n = 1
    //           head            n = 0
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return rec(head, new int[]{n});
    }

    public ListNode rec (ListNode head, int[] n) {
        if (head == null) {
            return null;
        }
        head.next = rec(head.next, n);

        n[0]--;

        if (n[0] == 0) {
            return head.next;
        }
        return head;
    }
}
