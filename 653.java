// Two Sum IV - Input is a BST
// 6 May 2020

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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (set.contains(k - curr.val))
                return true;
            set.add(curr.val);
            if (curr.left != null) queue.offer(curr.left);
            if (curr.right != null) queue.offer(curr.right);
        }
        return false;
    }
}