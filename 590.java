// N-ary Tree Postorder Traversal
// 10 April 2020

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

// Recursive Solution
class Solution {
    public List<Integer> postorder(Node root) {
        if (root == null) return new ArrayList<>();
        return traverse(root, new ArrayList<>());
    }
    
    public List<Integer> traverse(Node curr, List<Integer> order) {
        if (curr.children.size() == 0) {
            order.add(curr.val);
            return order;
        } else {
            int n = curr.children.size();
            for (int i = 0; i < n; i++) {
                order = traverse(curr.children.get(i), order);
            }
            order.add(curr.val);
            return order;
        }
    }
}

// Iterative Solution
class Solution {
    public List<Integer> postorder(Node root) {
        Stack<Node> s = new Stack<>();
        Set<Node> set = new HashSet<>();
        List<Integer> order = new ArrayList<>();
        if (root == null) return order;
        
        s.push(root);
        
        while (!s.isEmpty()) {
            Node curr = s.pop();
            System.out.println(curr.val);
            if (curr.children.size() == 0) {
                order.add(curr.val);
            } else {
                s.push(curr);
                int n = curr.children.size();
                for (int i = n-1; i >= 0; i--) {
                    s.push(curr.children.get(i));
                    curr.children.remove(i);
                }
            }
        }
        return order;
        
    }
    
}