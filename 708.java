// Insert into a Sorted Circular Linked List
// 27 March 2020

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        Node newNode = new Node(insertVal);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        Node curr = head;
        if (curr.next == curr) {
            curr.next = newNode;
            newNode.next = curr;
            return curr;
        }
        while (true) {
            if (curr.val <= insertVal && insertVal <= curr.next.val) {
                newNode.next = curr.next;
                curr.next = newNode;
                return head;
            }
            if (curr.val > curr.next.val) {
                if (curr.val < insertVal || insertVal <= curr.next.val) {
                    newNode.next = curr.next;
                    curr.next = newNode;
                    return head;
                }
            }
            curr = curr.next;
            if (curr.next == head) {
                newNode.next = head;
                curr.next = newNode;
                return head;
            }
        }
    }
}