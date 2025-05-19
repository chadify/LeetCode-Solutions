class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> wraplist = new ArrayList<>();
        
        if (root == null) return wraplist;
        
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            LinkedList<Integer> sublist = new LinkedList<>();

            for (int i = 0; i < levelNum; i++) {
                TreeNode currentNode = queue.poll();

                // Add the current node value to sublist based on the traversal direction
                if (leftToRight) {
                    sublist.add(currentNode.val);
                } else {
                    sublist.addFirst(currentNode.val);
                }

                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }

            // Toggle the direction
            leftToRight = !leftToRight;

            wraplist.add(sublist);
        }

        return wraplist;
    }
}