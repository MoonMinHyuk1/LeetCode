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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode answer = new ListNode();
        ListNode node = answer;

        while (list1 != null && list2 != null) {
            int num = 0;
            if (list1.val < list2.val) {
                num = list1.val;
                list1 = list1.next;
            } else {
                num = list2.val;
                list2 = list2.next;
            }
            node.next = new ListNode(num);
            node = node.next;
        }
        while (list1 != null) {
            node.next = new ListNode(list1.val);
            list1 = list1.next;
            node = node.next;
        }
        while (list2 != null) {
            node.next = new ListNode(list2.val);
            list2 = list2.next;
            node = node.next;
        }

        return answer.next;
    }
}