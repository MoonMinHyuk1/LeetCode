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
    int answer;

    public int sumNumbers(TreeNode root) {
        answer = 0;

        search(root, new StringBuilder());

        return answer;
    }

    private void search(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append(node.val);
        if (node.left == null && node.right == null) {
            answer += Integer.parseInt(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        search(node.left, sb);
        search(node.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}