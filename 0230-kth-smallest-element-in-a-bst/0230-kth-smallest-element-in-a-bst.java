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
    public int kthSmallest(TreeNode root, int k) {
        // move down the left
        if (root == null) {
            return -1;
        }

        int left = count(root.left);

        if (left + 1 == k) {
            return root.val;
        }
        else if (left + 1 < k) {
            return kthSmallest(root.right, k - left - 1);  // Adjust k
        }
        else {
            return kthSmallest(root.left, k);
        }
    }

    private int count(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return count(node.left) + count(node.right) + 1;
    }
}