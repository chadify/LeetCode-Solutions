/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list = new ArrayList<>();
        
        // Find all nodes at distance k from target
        findNodesAtDistanceK(root, target, k, list);
        
        return list;
    }

    private int findNodesAtDistanceK(TreeNode node, TreeNode target, int k, List<Integer> list) {
        if (node == null) {
            return -1;
        }
        
        // If current node is the target
        if (node == target) {
            // Find all nodes at distance k in target's subtree
            helper(node, k, list);
            return 0; // distance from target to itself
        }
        
        // Check if target is in left subtree
        int leftDistance = findNodesAtDistanceK(node.left, target, k, list);
        if (leftDistance != -1) {
            // Target found in left subtree
            // Check if current node is at distance k from target
            if (leftDistance + 1 == k) {
                list.add(node.val);
            }
            // Search in right subtree for nodes at remaining distance
            else if (leftDistance + 1 < k) {
                helper(node.right, k - leftDistance - 2, list);
            }
            return leftDistance + 1;
        }
        
        // Check if target is in right subtree
        int rightDistance = findNodesAtDistanceK(node.right, target, k, list);
        if (rightDistance != -1) {
            // Target found in right subtree
            // Check if current node is at distance k from target
            if (rightDistance + 1 == k) {
                list.add(node.val);
            }
            // Search in left subtree for nodes at remaining distance
            else if (rightDistance + 1 < k) {
                helper(node.left, k - rightDistance - 2, list);
            }
            return rightDistance + 1;
        }
        
        return -1; // target not found in this subtree
    }

    private void helper(TreeNode node, int k, List<Integer> list) {
        if (node == null || k < 0) {
            return;
        }

        if (k == 0) {
            list.add(node.val);
            return;
        }

        helper(node.left, k - 1, list);
        helper(node.right, k - 1, list);
    }
}