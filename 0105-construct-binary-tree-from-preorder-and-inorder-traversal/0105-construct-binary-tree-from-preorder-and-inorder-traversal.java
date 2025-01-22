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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(preorder, inorder, 0, preorder.length - 1);
    }

    private TreeNode construct(int[] preorder, int[] inorder, int s, int e) {
        if (s > e) {
            return null;
        }
        int index = 0;
        for (int i = s; i <= e; i++) {
            if (preorder[pi] == inorder[i]) {
                index = i;
                pi++;
                break;
            }
        }
        TreeNode node = new TreeNode(inorder[index]);
        node.left = construct(preorder, inorder, s, index - 1);
        node.right = construct(preorder, inorder, index + 1, e);
        return node;
    }
}