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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode answer = new ListNode();
        ListNode nowNode = answer;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.offer(new int[]{i, lists[i].val});
            }
        }
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            nowNode.next = new ListNode(now[1]);
            nowNode = nowNode.next;
            ListNode node = lists[now[0]];
            if (node.next != null) {
                pq.offer(new int[]{now[0], node.next.val});
                lists[now[0]] = lists[now[0]].next;
            }
        }

        return answer.next;
    }
}