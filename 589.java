// N-ary Tree Preorder Traversal
// 12 May 2020

// O(n) time and space
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> values = new ArrayList<>();
        helper(root, values);
        return values;
    }
    
    private void helper(Node root, List<Integer> values) {
        if (root == null) return;
        values.add(root.val);
        for (Node child : root.children)
            helper(child, values);
    }
}

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/