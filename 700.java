// Search in a Binary Search Tree
// 3 April 2020

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
    public TreeNode searchBST(TreeNode root, int val) {
        return find(root, val);
    }
    
    public static TreeNode find(TreeNode node, int val) {
        if (node == null) return null;
        if (node.val == val) return node;
        TreeNode l = find(node.left, val);
        TreeNode r = find(node.right, val);
        if (l != null) return l;
        if (r != null) return r;
        return null;
    }
}