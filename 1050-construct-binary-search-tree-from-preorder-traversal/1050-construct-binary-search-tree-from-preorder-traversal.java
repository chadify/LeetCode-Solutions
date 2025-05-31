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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = construct(preorder);
        return root;
    }

    public static TreeNode insertBST(TreeNode root, int key) {
        if (root == null)
            return new TreeNode(key);
        if (root.val > key)
            root.left = insertBST(root.left, key);
        else if (root.val < key)
            root.right = insertBST(root.right, key);
        return root;
    }

    // Constructs BST from the given Preorder Traversal
    public static TreeNode construct(int[] preorder) {
        TreeNode root = null;

        // One by one insert all keys from pre[]
        for (int key : preorder) {
            root = insertBST(root, key);
        }

        return root;
    } 
}