// Closest Binary Search Tree Value
// 31 March 2020

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
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        double distance = Math.abs(closest-target);
        TreeNode curr = root;
        while (curr != null) {
            // double x = curr.val;
            double temp = Math.abs(curr.val-target);
            if (temp < distance) {
                distance = temp;
                closest = curr.val;
            }
            if (curr.val < target) {
                curr = curr.right;
            } else if (curr.val > target) {
                curr = curr.left;
            } else {
                break;
            }
        }
        return closest;
    }
}