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
    private int diameter; 
    public int diameterOfBinaryTree(TreeNode root) {
        //recursively find the max heights for both left and right subtrees, sum them
        //update this global sum variable for all nodes
        //return this max variable
        diameter = 0;
        int height = dfs(root);
        return diameter;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int heightl = dfs(node.left);
        int heightr = dfs(node.right);

        diameter = Math.max(heightl + heightr, diameter);

        return Math.max(heightl, heightr) + 1; 
    }
}