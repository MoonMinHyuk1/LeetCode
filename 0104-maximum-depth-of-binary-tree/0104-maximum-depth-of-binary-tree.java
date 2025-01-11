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
    
    int max;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        max = 1;
        findMax(root, 1);

        return max;
    }

    public void findMax(TreeNode root, int depth) {
        max = Math.max(max, depth);
        if (root.left != null) {
            findMax(root.left, depth + 1);
        }
        if (root.right != null) {
            findMax(root.right, depth + 1);
        }
    }
}