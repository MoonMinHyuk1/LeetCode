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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        search(root, list);
        TreeNode node = new TreeNode();
        TreeNode head = node;
        for (int i = 0; i < list.size(); i++) {
            node.right = new TreeNode(list.get(i));
            node = node.right;
        }
        root.left = null;
        root.right = head.right.right;
    }

    private void search(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        search(root.left, list);
        search(root.right, list);
    }
}