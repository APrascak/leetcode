// Sum of Left Leaves
// 12 May 2020

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
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }
    
    private int helper(TreeNode curr, boolean valid) {
        if (curr == null) return 0;
        if (curr.left == null && curr.right == null) {
            if (valid) {
                return curr.val;
            } else {
                return 0;
            }
        }
        return helper(curr.left, true) + helper(curr.right, false);
    }
}