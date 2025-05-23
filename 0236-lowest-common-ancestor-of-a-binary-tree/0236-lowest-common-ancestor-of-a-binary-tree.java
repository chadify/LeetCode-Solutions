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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // to store paths to n1 and n2 from the root
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();

        // Find paths from root to n1 and 
        // root to n2. If either
        // n1 or n2 is not present, return null.
        if(!findPath(root, path1, p.val) ||
                 !findPath(root, path2, q.val))
            return null;

        // Compare the paths to get the first
        // different value
        int i;
        for(i = 0; i<path1.size() &&
                     i<path2.size(); i++) {
            if(path1.get(i) != path2.get(i))
                return path1.get(i-1);
        }

        // if both the datas are same, return last node
        return path1.get(i-1);
    }

    // Finds the path from root to given node
    private static boolean findPath(TreeNode root, List<TreeNode> path, int n) {

        // base case
        if (root == null) {
            return false;
        }

        // Store current node
        path.add(root);

        if (root.val == n ||
            findPath(root.left, path, n) ||
            findPath(root.right, path, n)) {
            return true;
        }

        // remove root from path and return false
        path.remove(path.size() - 1);

        return false;
    }
}