// Leaf-Similar Trees
// 30 April 2020

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
    String value1;
    String value2;
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        value1 = helper(root1);
        value2 = helper(root2);
        // System.out.println(value1 + " " + value2);
        return value1.equals(value2);
    }
    
    public String helper(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        Set<TreeNode> seen = new HashSet<>();
        String ans = "";
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode curr = s.pop();
            while (curr.left != null && !seen.contains(curr.left)) {
                s.push(curr);
                curr = curr.left;
            }
            if (curr.left == null && curr.right == null) ans += curr.val + ",";
            seen.add(curr);
            if (curr.right != null) {
                s.push(curr.right);
            }
        }
        return ans;
    }
}