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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // Handle empty tree case
        if (root == null) {
            return new TreeNode(val);
        }
        
        helper(root, val);
        return root;
    }
    
    private void helper(TreeNode root, int val) {
        if (root.val < val) {
            if (root.right != null) {
                helper(root.right, val);
            }
            else {
                root.right = new TreeNode(val);
            }
        }
        else {
            if (root.left != null) {
                helper(root.left, val);
            }
            else {
                root.left = new TreeNode(val);
            }
        }
    }
}