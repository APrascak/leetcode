// Find Duplicate Subtrees
// 29 April 2020

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
    Map<String, Integer> seen;
    List<TreeNode> duplicates;
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        duplicates = new ArrayList<>();
        seen = new HashMap<>();
        helper(root);
        return duplicates;
    }
    
    private String helper(TreeNode curr) {
        if (curr == null) return "#";
        String st = helper(curr.left) + "," + String.valueOf(curr.val) + "," + helper(curr.right) + " ";
        if (seen.getOrDefault(st, 0) == 1) duplicates.add(curr);
        seen.put(st, seen.getOrDefault(st, 0) + 1);
        return st;
    }
}