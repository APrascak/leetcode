// Count Univalue Subtrees
// 24 April 2020

// O(n) solution with O(1) time (17 May 2020)
class Solution {
    int max = 0;
    public int countUnivalSubtrees(TreeNode root) {
        helper(root);
        return max;
    }
    
    private boolean helper(TreeNode curr) {
        if (curr == null)
            return true;
        boolean left = helper(curr.left);
        boolean right = helper(curr.right);
        if (left && right) {
            if (curr.left != null && curr.left.val != curr.val)
                return false;
            if (curr.right != null && curr.right.val != curr.val)
                return false;
            max++;
            return true;
        }
        return false;
    }
}

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