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
    public int countNodes(TreeNode root) {
        // find the right most leaf node using dfs
        // nodes = 2 * h - 1 + 
        if (root == null) return 0;

        int left = countLeftHeight(root.left);
        int right = countRightHeight(root.right);

        if (left == right) {
            return (2 << left) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int countLeftHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    private int countRightHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }
}