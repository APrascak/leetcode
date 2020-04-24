// Count Univalue Subtrees
// 24 April 2020

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
    int count;
    
    public int countUnivalSubtrees(TreeNode root) {
        count = 0;
        countTrees(root);
        return count;
    }
    
    public boolean countTrees(TreeNode curr) {
        if (curr == null) return false;
        if (curr.left == null && curr.right == null) {
            count++;
            return true;
        }
        if (curr.left == null) {
            boolean rightIsValid = countTrees(curr.right);
            if (rightIsValid) {
                if (curr.right.val == curr.val) {
                    count++;
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else if (curr.right == null) {
            boolean leftIsValid = countTrees(curr.left);
            if (leftIsValid) {
                if (curr.left.val == curr.val) {
                    count++;
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            boolean rightIsValid = countTrees(curr.right);
            boolean leftIsValid  = countTrees(curr.left);
            if (leftIsValid && rightIsValid && curr.right.val == curr.val && curr.left.val == curr.val) {
                count++;
                return true;
            } else {
                return false;
            }
        }
        
    }
}