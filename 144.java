// Binary Tree Preorder Traversal
// 10 April 2020

// Iterative Solution
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> order = new ArrayList<>();
        if (root == null) return order;
        s.push(root);
        
        while (!s.isEmpty()) {
            TreeNode curr = s.pop();
            order.add(curr.val);
            if (curr.right != null) s.push(curr.right);
            if (curr.left != null) s.push(curr.left);
        }
        return order;
    }
}

// Recursive Solution
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        return traverse(root, new ArrayList<>());
    }
    
    public List<Integer> traverse(TreeNode curr, List<Integer> order) {
        if (curr == null) return order;
        order.add(curr.val);
        order = traverse(curr.left, order);
        order = traverse(curr.right, order);
        return order;
        
    }
}