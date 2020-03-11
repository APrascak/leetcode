// Flatten a Multilevel Doubly Linked List
// 10 March 2020

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
class Solution {
    public Node flatten(Node head) {
        
        Node curr = head;
        
        while (curr != null) {
            if (curr.child != null) {
                curr.child.prev = curr;
                curr = curr.child;
            } else if (curr.next == null) {
                Node temp = curr;
                //print(head);
                while (curr.child == null) {
                    curr = curr.prev;
                    if (curr == head && curr.child == null) {
                        return head;
                    }
                }
                if (curr.next == null) {
                    curr.next = curr.child;
                    curr.child = null;
                } else {
                    curr.next.prev = temp;
                    temp.next = curr.next;
                    curr.next = curr.child;
                    curr.child = null;
                }
            } else {
                curr = curr.next;
            }
        }
        
        return head;
    }
    
    public void print(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
        System.out.println("DONE WITH CALL");
    }
}