// Construct Binary Search Tree from Preorder Traversal
// 20 April 2020

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
    public TreeNode bstFromPreorder(int[] preorder) {
        Stack<TreeNode> s = new Stack<>();
        int n = preorder.length;
        
        if (n == 0) return null;
        if (n == 1) return new TreeNode(preorder[0]);
        
        TreeNode root = new TreeNode(preorder[0]);
        s.push(root);
        TreeNode curr;
        
        for (int i = 1; i < n; i++) {
            curr = new TreeNode(preorder[i]);
            if (s.isEmpty()) break;
            if (preorder[i] < s.peek().val) {
                s.peek().left = curr;
                s.push(curr);
                continue;
            } else {
                TreeNode temp = s.peek();
                while (!s.isEmpty() && preorder[i] > s.peek().val) {
                    temp = s.pop();
                }
                temp.right = curr;
                s.push(curr);
            }
        }
        return root;
    }
}