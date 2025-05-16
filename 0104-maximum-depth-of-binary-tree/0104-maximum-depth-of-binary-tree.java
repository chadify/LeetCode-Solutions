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
    public int maxDepth(TreeNode root) {
        // for every children found down, increase height
        int depth = 0;

        return helper(root, depth);
    }

    public static int helper(TreeNode node, int count) {
        if (node == null) return count;

        count = Math.max(helper(node.left, count + 1), helper(node.right, count + 1));
        return count;
    }
}