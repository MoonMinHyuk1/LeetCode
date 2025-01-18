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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode answer = new TreeNode(root.val);

        search(root, answer);

        return answer;
    }

    public void search(TreeNode root, TreeNode answer) {
        if (root.left != null) {
            answer.right = new TreeNode(root.left.val);
            search(root.left, answer.right);
        }
        if (root.right != null) {
            answer.left = new TreeNode(root.right.val);
            search(root.right, answer.left);
        }
    }
}