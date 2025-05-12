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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> traversal = new ArrayList<>();

        preTraversal(root, traversal);

        return traversal;
    }

    public static List<Integer> preTraversal(TreeNode root, ArrayList<Integer> traversal) {
        if (root == null) {
            return null;
        }

        traversal.add(root.val);

        preTraversal(root.left, traversal);
        preTraversal(root.right, traversal);

        return traversal;
    }
}