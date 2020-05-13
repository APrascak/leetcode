// N-ary Tree Level Order Traversal
// 12 May 2020

// O(n) time and space
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> solution = new ArrayList<>();
        if (root == null) return solution;
        Queue<Node> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                level.add(curr.val);
                for (Node child : curr.children)
                    queue.offer(child);
            }
            solution.add(level);
        }
        return solution;
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