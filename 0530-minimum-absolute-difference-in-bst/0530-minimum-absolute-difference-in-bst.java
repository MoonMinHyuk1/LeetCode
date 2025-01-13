/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int getMinimumDifference(TreeNode root) {
        int answer = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        search(root, pq);
        int now = pq.poll();
        while (!pq.isEmpty()) {
            int next = pq.poll();
            answer = Math.min(answer, next - now);
            now = next;
        }

        return answer;
    }

    public void search(TreeNode node, PriorityQueue<Integer> pq) {
        if (node == null) {
            return;
        }
        pq.offer(node.val);
        search(node.left, pq);
        search(node.right, pq);
    }
}