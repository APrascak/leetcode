// Diameter of Binary Tree
// 11 April 2020

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
    int ans = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        calc(root);
        return ans;
    }
    
    public int calc(TreeNode curr) {
        if (curr == null) return 0;
        int left  = calc(curr.left);
        int right = calc (curr.right);
        ans = Math.max(ans, left + right);
        return Math.max(left, right) + 1;
    } 
}