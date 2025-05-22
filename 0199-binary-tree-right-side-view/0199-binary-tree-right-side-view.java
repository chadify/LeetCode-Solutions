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
    public List<Integer> rightSideView(TreeNode root) {
        // use BFS traversal and for every level return the rightmost node
        List<Integer> result = new ArrayList<>();
        
        // Handle null root case
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNode node = null;
            
            // Process all nodes at current level
            for (int i = 0; i < levelSize; i++) {
                node = queue.poll();
                
                // Add children to queue for next level (left first, then right)
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            
            // Add the rightmost node of current level to result
            result.add(node.val);
        }
        
        return result;
    }
}