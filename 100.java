// Same Tree
// 4 May 2020

// Recursive Solution: O(n) time with O(logN) average space with O(n) for unbalanced tree
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

// Iterative Solution: same complexities
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (!check(p,q)) return false;
        Stack<TreeNode> sp = new Stack<>();
        Stack<TreeNode> sq = new Stack<>();
        if (p == null) return true;
        sp.push(p);
        sq.push(q);
        
        while (!sp.isEmpty()) {
            p = sp.pop();
            q = sq.pop();
            if (!check(p.left, q.left)) return false;
            if (p.left != null) {
                sp.push(p.left);
                sq.push(q.left);
            }
            if (!check(p.right, q.right)) return false;
            if (p.right != null) {
                sp.push(p.right);
                sq.push(q.right);
            }
        }
        return true;
    }
    
    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return true;
    }
}

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