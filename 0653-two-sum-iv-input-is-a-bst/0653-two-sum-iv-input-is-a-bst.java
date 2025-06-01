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

class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    boolean reverse;

    public BSTIterator(TreeNode root, boolean isReverse) {
        reverse = isReverse;
        pushAll(root);
    }

    public void pushAll(TreeNode node) {
        while (node != null){
            stack.push(node);
            if (reverse) {
                node = node.right;
            }
            else {
                node = node.left;
            }
        }
    }

    public int next() {
        TreeNode tmpNode = stack.pop();
        if (reverse) {
            pushAll(tmpNode.left);
        }
        else {
            pushAll(tmpNode.right);
        }
        return tmpNode.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}


class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);

        int i = l.next();
        int j = r.next();

        while (i < j) {
            if (i + j == k) {
                return true;
            }

            else if (i + j < k) {
                i = l.next();
            }
            else {
                j = r.next();
            }
        }

        return false;
    }
}