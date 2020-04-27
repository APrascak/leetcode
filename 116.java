// Populating Next Right Pointers in Each Node
// 26 April 2020

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node ref = queue.poll();
                if (i == size-1) {
                    ref.next = null;
                } else {
                    ref.next = queue.peek();
                }
                if (ref.left == null) break;
                queue.offer(ref.left);
                queue.offer(ref.right);
            }
        }
        return root;
    }
}