// Minimum Depth of Binary Tree
// 27 May 2020

// O(n) time, O(n) space
class Solution {
    public int minDepth(TreeNode root) {
        int depth = 0;
        if (root == null)
            return depth;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left == null && curr.right == null)
                    return depth;
                if (curr.left != null)
                    queue.offer(curr.left);
                if (curr.right != null)
                    queue.offer(curr.right);
            }
        }
        return depth;
    }
}