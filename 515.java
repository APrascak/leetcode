// Find Largest Value in Each Tree Row
// 28 April 2020

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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> solution = new ArrayList<>();
        if (root == null) return solution;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int rowMax = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                rowMax = Math.max(rowMax, curr.val);
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            solution.add(rowMax);
        }
        return solution;
    }
}