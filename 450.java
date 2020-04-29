// Delete Node in a BST
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
    public TreeNode deleteNode(TreeNode root, int key) {
        return helper(root, key);
    }
    
    private TreeNode helper(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.right == null && root.left == null) {
                return null;
            } else if (root.right != null && root.left != null) {
                TreeNode ref = root.left;
                TreeNode curr = ref;
                while (curr.right != null) {
                    curr = curr.right;
                }
                curr.right = root.right;
                return ref;
            } else if (root.left == null) {
                return root.right;
            } else {
                return root.left;
            }
        }
        if (root.val < key) {
            root.right = helper(root.right, key);
            return root;
        } else {
            root.left = helper(root.left, key);
            return root;
        }
    }
}