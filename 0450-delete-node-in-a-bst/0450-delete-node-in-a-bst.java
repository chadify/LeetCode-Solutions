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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        
        TreeNode parent = null;
        TreeNode deletedNode = null;
        TreeNode current = root;
        
        // Search for the node to delete
        while (current != null) {
            if (current.val == key) {
                deletedNode = current;
                break;
            }
            parent = current;
            if (current.val < key) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        
        // If node not found
        if (deletedNode == null) {
            return root;
        }
        
        // Handle deletion based on your original logic
        if (deletedNode.right != null) {
            // Replace deletedNode with its right child
            if (parent == null) {
                // Deleting root node
                root = deletedNode.right;
            } else if (parent.left == deletedNode) {
                parent.left = deletedNode.right;
            } else {
                parent.right = deletedNode.right;
            }
            
            // If left subtree exists, attach it to leftmost node of right subtree
            if (deletedNode.left != null) {
                TreeNode delRightChild = deletedNode.right;
                while (delRightChild.left != null) {
                    delRightChild = delRightChild.left;
                }
                delRightChild.left = deletedNode.left;
            }
        } else if (deletedNode.left != null) {
            // Replace deletedNode with its left child
            if (parent == null) {
                // Deleting root node
                root = deletedNode.left;
            } else if (parent.left == deletedNode) {
                parent.left = deletedNode.left;
            } else {
                parent.right = deletedNode.left;
            }
        } else {
            // Leaf node - simply remove
            if (parent == null) {
                // Deleting root node (which is a leaf)
                root = null;
            } else if (parent.left == deletedNode) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        
        return root;
    }
}