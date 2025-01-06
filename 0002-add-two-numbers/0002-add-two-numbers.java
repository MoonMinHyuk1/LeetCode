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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode();
        ListNode now = answer;
        int plus = 0;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + plus;
            plus = sum / 10;
            now.next = new ListNode(sum % 10);
            now = now.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + plus;
            plus = sum / 10;
            now.next = new ListNode(sum % 10);
            now = now.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + plus;
            plus = sum / 10;
            now.next = new ListNode(sum % 10);
            now = now.next;
            l2 = l2.next;
        }
        if (plus == 1) {
            now.next = new ListNode(1);
        }

        return answer.next;
    }
}