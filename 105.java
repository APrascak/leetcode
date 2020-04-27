// Construct Binary Tree from Preorder and Inorder Traversal
// 26 April 2020

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
    int preorderIndex;
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> map = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorderIndex = 0;
        this.preorder = preorder;
        this.inorder  = inorder;
        // this.map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(0, inorder.length);
    }
    
    private TreeNode helper(int start, int end) {
        if (start == end) return null;
        
        int rootValue = preorder[preorderIndex];
        TreeNode root = new TreeNode(rootValue);
        preorderIndex++;
        
        int index = map.get(rootValue);
        
        root.left = helper(start, index);
        root.right = helper(index + 1, end);
        return root;
    }
}