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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode answer = new ListNode();
        ListNode temp = head;
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        k %= list.size();
        if (k == 0) {
            return temp;
        }
        int index = list.size() - k;
        ListNode node = answer;
        for (int i = 0; i < list.size(); i++) {
            node.next = new ListNode(list.get(index));
            node = node.next;
            index = (index + 1) % list.size();
        }

        return answer.next;
    }
}