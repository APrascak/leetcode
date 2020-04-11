// Path Sum
// 10 April 2020

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
    public boolean hasPathSum(TreeNode root, int sum) {
        return pathSum(root, 0, sum);
    }
    
    public boolean pathSum(TreeNode curr, int val, int sum) {
        if (curr == null) return false;
        if (curr.left == null && curr.right == null) return (val + curr.val) == sum;
        return pathSum(curr.left, val + curr.val, sum) || pathSum(curr.right, val + curr.val, sum);
    }
}