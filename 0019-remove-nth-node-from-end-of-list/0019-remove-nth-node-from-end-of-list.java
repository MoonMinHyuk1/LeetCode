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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        int len = 0;

        while (node != null) {
            len++;
            node = node.next;
        }
        if (len == 1) {
            return null;
        }
        if (len == n) {
            return head.next;
        }
        node = head;
        int index = len - n;
        while (--index > 0) {
            node = node.next;
        }
        node.next = node.next.next;

        return head;
    }
}