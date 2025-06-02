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
    private TreeNode first;
    private TreeNode prev;
    private TreeNode middle;
    private TreeNode last;
    public void recoverTree(TreeNode root) {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if (last != null) {
            // swap first with last
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        else {
            // swap first with middle
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.left);

        if (prev != null && node.val < prev.val) {
            if (first == null) {
                first = prev;
                middle = node;
            }
            else {
                last = node;
            }
        }

        prev = node;
        inorder(node.right);
    }

}