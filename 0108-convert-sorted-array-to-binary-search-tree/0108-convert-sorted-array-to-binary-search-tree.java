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
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = new TreeNode();

        divideAndConquer(root, nums, 0, nums.length - 1);

        return root;
    }

    public void divideAndConquer(TreeNode root, int[] nums, int s, int e) {
        int index = (s + e) / 2;
        root.val = nums[index];
        if (s <= index - 1) {
            root.left = new TreeNode();
            divideAndConquer(root.left, nums, s, index - 1);
        }
        if (index + 1 <= e) {
            root.right = new TreeNode();
            divideAndConquer(root.right, nums, index + 1, e);
        }
    }
}