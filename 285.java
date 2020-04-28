// Inorder Successor in BST
// 28 April 2020

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
    int minClosest = Integer.MAX_VALUE;
    TreeNode answer = null;
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        helper(root, p);
        return answer;
    }
    
    public void helper(TreeNode root, TreeNode p) {
        if (root == null) return;
        if (root.val > p.val) {
            minClosest = Math.min(minClosest, root.val);
            if (minClosest == root.val) answer = root;
            helper(root.left, p);
        } else if (root.val < p.val) {
            helper(root.right, p);
        } else {
            helper(root.right, p);
        }
    }
}