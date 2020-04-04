// Maximum Depth of Binary Tree
// 4 April 2020

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
    public int maxDepth(TreeNode root) {
        return find(root, 0);
    }
    
    public int find(TreeNode curr, int x) {
        if (curr == null) return x;
        return Math.max(find(curr.left, x+1), find(curr.right, x+1));
    }
}