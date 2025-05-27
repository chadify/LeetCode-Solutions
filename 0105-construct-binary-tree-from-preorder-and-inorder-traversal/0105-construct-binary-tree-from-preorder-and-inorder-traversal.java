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
import java.util.*;

class Solution {
    private int preorderIndex = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0) {
            return null;
        }
        
        // Convert inorder array to queue for easier manipulation
        Queue<Integer> inorderQueue = new LinkedList<>();
        for (int val : inorder) {
            inorderQueue.offer(val);
        }
        
        return buildTreeHelper(preorder, inorderQueue);
    }
    
    private TreeNode buildTreeHelper(int[] preorder, Queue<Integer> inorderQueue) {
        if (inorderQueue.isEmpty() || preorderIndex >= preorder.length) {
            return null;
        }
        
        // Get the next node from preorder traversal
        int nodeVal = preorder[preorderIndex++];
        TreeNode node = new TreeNode(nodeVal);
        
        // If this is a leaf node (only one element in inorder queue)
        if (inorderQueue.size() == 1) {
            inorderQueue.poll(); // Remove the processed node
            return node;
        }
        
        // Find the position of current node in inorder queue
        int index = findIndex(nodeVal, inorderQueue);
        
        if (index == -1) {
            // This shouldn't happen with valid input
            return node;
        }
        
        // Split inorder queue into left and right subtrees
        Queue<Integer> leftInorder = new LinkedList<>();
        Queue<Integer> rightInorder = new LinkedList<>();
        
        splitQueue(inorderQueue, index, leftInorder, rightInorder);
        
        // Build left and right subtrees
        node.left = buildTreeHelper(preorder, leftInorder);
        node.right = buildTreeHelper(preorder, rightInorder);
        
        return node;
    }
    
    private int findIndex(int target, Queue<Integer> queue) {
        int index = 0;
        for (Integer val : queue) {
            if (val == target) {
                return index;
            }
            index++;
        }
        return -1;
    }
    
    private void splitQueue(Queue<Integer> original, int splitIndex, 
                           Queue<Integer> left, Queue<Integer> right) {
        List<Integer> list = new ArrayList<>(original);
        
        // Add elements before splitIndex to left queue
        for (int i = 0; i < splitIndex; i++) {
            left.offer(list.get(i));
        }
        
        // Add elements after splitIndex to right queue
        for (int i = splitIndex + 1; i < list.size(); i++) {
            right.offer(list.get(i));
        }
        
        // Clear original queue
        original.clear();
    }
}
