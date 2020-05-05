// Convert Binary Search Tree to Sorted Doubly Linked List
// 4 May 2020

class Solution {
    Node first;
    Node prev;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        first = null;
        prev = null;
        helper(root);
        first.left = prev;
        prev.right = first;
        return first;
        
    }
    
    private void helper(Node curr) {
        if (curr == null) return;
        if (curr.left != null)
            helper(curr.left);
        if (first == null) {
            first = curr;
            prev = curr;
        } else {
            curr.left = prev;
            prev.right = curr;
            prev = curr;
        }
        helper(curr.right);
    } 
}

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/