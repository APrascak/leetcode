// Convert Sorted Array to Binary Search Tree
// 29 April 2020

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
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    
    private TreeNode helper(int[] nums, int low, int high) {
        if (low > high) return null;
        int midpoint = (low+high) / 2;
        int currValue = nums[midpoint];
        TreeNode curr = new TreeNode(currValue);
        curr.left = helper(nums, low, midpoint-1);
        curr.right = helper(nums, midpoint+1, high);
        return curr;
    }
}