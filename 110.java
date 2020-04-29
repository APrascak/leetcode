// Balanced Binary Tree
// 29 April 2020

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
    boolean answer;
    
    public boolean isBalanced(TreeNode root) {
        answer = true;
        helper(root);
        return answer;
    }
    
    private int helper(TreeNode curr) {
        if (curr == null) return 0;
        int leftDepth = helper(curr.left);
        int rightDepth = helper(curr.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            answer = false;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }
}