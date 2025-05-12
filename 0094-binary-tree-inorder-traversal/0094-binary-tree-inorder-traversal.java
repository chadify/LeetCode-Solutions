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
    public List<Integer> inorderTraversal(TreeNode root) {
        // left root right
        ArrayList<Integer> traversal = new ArrayList<>();

        inTraversal(root, traversal);

        return traversal;
    }

    public static ArrayList<Integer> inTraversal(TreeNode node, ArrayList<Integer> traversal) {
        if (node == null) {
            return null;
        }

        inTraversal(node.left, traversal);  //go the left part
        traversal.add(node.val); //add node
        inTraversal(node.right, traversal); //go the right part

        return traversal;
    }
}