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
    class CustomTreeNode {
        TreeNode node;
        int number;
        int level;

        CustomTreeNode(TreeNode node, int number, int level) {
            this.node = node;
            this.number = number;
            this.level = level;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        Queue<CustomTreeNode> queue = new LinkedList<>();
        queue.offer(new CustomTreeNode(root, 1, 0));

        int res = 0, prevLevel = 0, prevNum = 1;

        while(!queue.isEmpty()) {
            CustomTreeNode wrapper = queue.poll();
            TreeNode node = wrapper.node;
            int num = wrapper.number, level = wrapper.level;

            if (level > prevLevel) {
                prevLevel = level;
                prevNum = num;
            }

            res = Math.max(res, num - prevNum + 1);

            if (node.left != null) {
                queue.offer(new CustomTreeNode(node.left, 2 * num, level + 1));
            }
            if (node.right != null) {
                queue.offer(new CustomTreeNode(node.right, 2 * num + 1, level + 1));
            }
        }

        return res;
    }
}