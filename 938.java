// Range Sum of BST
// 14 April 2020

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
    public int rangeSumBST(TreeNode root, int L, int R) {
        return findSum(root, L, R);
    }
    
    public int findSum(TreeNode curr, int L, int R) {
        if (curr == null) return 0;
        if (curr.val < L) return findSum(curr.right, L, R);
        if (curr.val > R) return findSum(curr.left, L, R);
        return curr.val + findSum(curr.left, L, R) + findSum(curr.right, L, R);
    }
}