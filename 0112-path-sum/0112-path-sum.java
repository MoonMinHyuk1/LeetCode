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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        return search(root, targetSum, root.val);
    }

    private boolean search(TreeNode node, int target, int sum) {
        if (target == sum && node.left == null && node.right == null) {
            return true;
        }
        if (node.left != null && node.right != null) {
            return search(node.left, target, sum + node.left.val) || search(node.right, target, sum + node.right.val);
        }
        if (node.left != null) {
            return search(node.left, target, sum + node.left.val);
        }
        if (node.right != null) {
            return search(node.right, target, sum + node.right.val);
        }

        return false;
    }
}