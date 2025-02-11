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
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode();
        ListNode great = new ListNode();
        ListNode lessNode = less;
        ListNode greatNode = great;

        while (head != null) {
            if (head.val < x) {
                lessNode.next = new ListNode(head.val);
                lessNode = lessNode.next;
            } else {
                greatNode.next = new ListNode(head.val);
                greatNode = greatNode.next;
            }
            head = head.next;
        }
        lessNode.next = great.next;

        return less.next;
    }
}