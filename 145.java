// Binary Tree Postorder Traversal
// 10 April 2020

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Iterative Solution
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> order = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        Set<TreeNode> set = new HashSet<>();
        if (root == null) return order;
        
        s.push(root);
        
        
        while (!s.isEmpty()) {
            TreeNode curr = s.pop();
            while (curr.left != null && !set.contains(curr.left)) {
                s.push(curr);
                set.add(curr);
                curr = curr.left;
            }
            if (curr.right != null && !set.contains(curr.right)) {
                s.push(curr);
                set.add(curr);
                s.push(curr.right);
                continue;
            }
            set.add(curr);
            order.add(curr.val);
        }
        
        return order;
        
    }
    
}

// Recursive Solution
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        return traverse(root, new ArrayList<>());
    }
    
    public List<Integer> traverse(TreeNode curr, List<Integer> order) {
        if (curr == null) return order;
        order = traverse(curr.left, order);
        order = traverse(curr.right, order);
        order.add(curr.val);
        return order;
    }
}