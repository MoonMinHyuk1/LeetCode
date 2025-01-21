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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode node = head;
        
        while (left < right) {
            ListNode leftPrevNode = search(head, left - 1);
            ListNode leftNode = search(head, left);
            ListNode rightPrevNode = search(head, right - 1);
            ListNode rightNode = search(head, right);
            if (leftPrevNode != null) {
                leftPrevNode.next = rightNode;
            }
            rightPrevNode.next = leftNode;
            ListNode temp = leftNode.next;
            leftNode.next = rightNode.next;
            rightNode.next = temp;
            if (leftPrevNode == null) {
                head = rightNode;
            }
            left++;
            right--;
        }

        return head;
    }

    private ListNode search(ListNode node, int index) {
        if (index == 0) {
            return null;
        }
        for (int i = 1; i < index; i++) {
            node = node.next;
        }

        return node;
    }
}