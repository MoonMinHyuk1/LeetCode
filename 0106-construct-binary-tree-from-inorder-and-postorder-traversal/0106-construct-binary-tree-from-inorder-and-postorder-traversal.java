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

    int pi = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pi = postorder.length - 1;
        return construct(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode construct(int[] inorder, int[] postorder, int s, int e) {
        if (s > e) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[pi]);
        for (int i = s; i <= e; i++) {
            if (inorder[i] == postorder[pi]) {
                pi--;
                node.right = construct(inorder, postorder, i + 1, e);
                node.left = construct(inorder, postorder, s, i - 1);
                break;
            }
        }
        return node;
    }
}