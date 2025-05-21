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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // A TreeMap to store column -> list of [row, value] pairs
        Map<Integer, List<int[]>> columnMap = new TreeMap<>();
        
        // DFS to populate the map with node information
        dfs(root, 0, 0, columnMap);
        
        // Result list to build
        List<List<Integer>> result = new ArrayList<>();
        
        // Process each column
        for (int col : columnMap.keySet()) {
            // Sort nodes in this column: first by row, then by value
            List<int[]> nodes = columnMap.get(col);
            Collections.sort(nodes, (a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0]; // Sort by row first
                }
                return a[1] - b[1]; // If same row, sort by value
            });
            
            // Extract just the values for the result
            List<Integer> colResult = new ArrayList<>();
            for (int[] node : nodes) {
                colResult.add(node[1]);
            }
            
            result.add(colResult);
        }
        
        return result;
    }
    
    private void dfs(TreeNode node, int row, int col, Map<Integer, List<int[]>> columnMap) {
        if (node == null) {
            return;
        }
        
        // Add current node to the appropriate column list
        columnMap.computeIfAbsent(col, k -> new ArrayList<>()).add(new int[]{row, node.val});
        
        // Visit left and right children
        dfs(node.left, row + 1, col - 1, columnMap);
        dfs(node.right, row + 1, col + 1, columnMap);
    }
}