// Insert into a Binary Search Tree
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root.val < val) {
            if (root.right == null) {
                root.right = new TreeNode(val);
                return root;
            } else {
                insertIntoBST(root.right, val);
                return root;
            }
        } else {
            if (root.left == null) {
                root.left = new TreeNode(val);
                return root;
            } else {
                insertIntoBST(root.left, val);
                return root;
            }
        }
    }
}