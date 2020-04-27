// Construct Binary Tree from Inorder and Postorder Traversal
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
    int postorderIndex;
    int[] inorder;
    int[] postorder;
    Map<Integer, Integer> map;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length - 1;
        this.inorder = inorder;
        this.postorder = postorder;
        map = new HashMap<>();
        
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(0, inorder.length - 1);
    }
    
    private TreeNode helper(int start, int end) {
        if (start > end) return null;
        int rootValue = postorder[postorderIndex];
        TreeNode root = new TreeNode(rootValue);
        postorderIndex--;
        int index = map.get(rootValue);
        root.right = helper(index+1,end);
        root.left = helper(start,index-1);
        return root;
    }
}