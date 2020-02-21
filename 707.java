// Design Linked list
// 20 February 2020

class MyLinkedList {

    int length;
    Node head;
    
    class Node {
        int val;
        Node next;
        Node(int x) {
            this.val = x;
        }
    }
    
    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.length = 0;
        this.head = null;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        System.out.println(this.length);
        if (index < 0 || index >= this.length) {
            return -1;
        } else {
            int counter = 0;
            Node curr = head;
            while (counter != index) {
                curr = curr.next;
                counter++;
            }
            return curr.val;
        }
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = this.head;
        this.head = newNode;
        this.length++;
        System.out.println(this.length);
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (this.length == 0) {
            this.head = newNode;
        } else {
            Node curr = this.head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
            // newNode.next = null;
            this.length++;
        }
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == this.length) {
            addAtTail(val);
            return;
        }
        if (index > this.length) {
            return;
        }
        Node newNode = new Node(val);
        int counter = 0;
        Node curr = head;
        while (counter != (index-1)) {
            curr = curr.next;
            counter++;
        }
        newNode.next = curr.next;
        curr.next = newNode;
        this.length++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= this.length) {
            return;
        }
        Node curr = this.head;
        if (index == 0) {
            head = curr.next;
        } else {
            int counter = 0;
            Node pre = null;
            while (counter != (index-1)) {
                curr = curr.next;
                counter++;
            }
            curr.next = curr.next.next;
            this.length--;
        }
    }
}


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */