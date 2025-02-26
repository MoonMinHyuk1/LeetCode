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

    int answer, cnt;

    public int kthSmallest(TreeNode root, int k) {
        answer = -1;
        cnt = 0;

        search(root, k);

        return answer;
    }

    private void search(TreeNode node, int k) {
        if (node.left != null) {
            search(node.left, k);
        }
        cnt++;
        if (cnt == k) {
            answer = node.val;
        }
        if (node.right != null) {
            search(node.right, k);
        }
    }
}