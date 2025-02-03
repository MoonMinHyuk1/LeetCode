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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = new ListNode(Integer.MIN_VALUE);
        node.next = head;

        ListNode prev = node;
        ListNode now = node.next;
        while (now != null) {
            ListNode next = now.next;
            boolean flag = false;
            while (next != null && now.val == next.val) {
                next = next.next;
                flag = true;
            }
            if (flag) {
                prev.next = next;
                now = next;
            } else {
                prev = now;
                now = next;
            }
        }

        return node.next;
    }
}