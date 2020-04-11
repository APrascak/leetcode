// Binary Tree Inorder Traversal
// 10 April 2020

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> order = new ArrayList<>();
        Set<TreeNode> set = new HashSet<>();
        if (root == null) return order;
        TreeNode curr = root;
        
        s.push(root);
        
        while (!s.isEmpty()) {
            curr = s.pop();
            while (curr.left != null && !set.contains(curr.left)) {
                s.push(curr);
                curr = curr.left;
            }
            set.add(curr);
            order.add(curr.val);
            if (curr.right != null) s.push(curr.right);
        }
        return order;
    }
}
