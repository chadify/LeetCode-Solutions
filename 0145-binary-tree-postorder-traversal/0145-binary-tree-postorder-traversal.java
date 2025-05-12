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
    public List<Integer> postorderTraversal(TreeNode root) {
        //left right root
        ArrayList<Integer> traversal = new ArrayList<>();

        postTraversal(root, traversal);

        return traversal;
    }

    public static ArrayList<Integer> postTraversal(TreeNode node, ArrayList<Integer> traversal) {
        if (node == null) {
            return null;
        }

        postTraversal(node.left, traversal);
        postTraversal(node.right, traversal);
        traversal.add(node.val);

        return traversal;
    }
}