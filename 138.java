// Copy List with Random Pointer
// 10 March 2020

class Solution {
    public Node copyRandomList(Node head) {
        
        if (head == null) { return null; }
        
        Node solution = new Node(head.val);
        
        Node curr1 = head.next;
        Node curr2 = solution;
        int length = 1;
        
        // Copies initial nodes without random connections
        while (curr1 != null) {
            length++;
            Node copy = new Node(curr1.val);
            curr2.next = copy;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        
        Node c1 = head;
        Node c2 = solution;
        
        boolean behind;
        int position = 0;
        Node search;
        
        while (c2 != null && c1 != null) {
            if (c1.random != null) {
                int distance = 0;
                Node counter = c1.random;
                while (true) {
                    distance++;
                    counter = counter.next;
                    if (counter == c1) {
                        behind = true;
                        break;
                    }
                    if (counter == null) {
                        behind = false;
                        break;
                    }
                }
                if (behind) {
                    search = solution;
                    for (int i = 0; i < position-distance; i++) {
                        search = search.next;
                    }
                    c2.random = search;
                } else {
                    search = c2;
                    for (int i = 0; i < length-distance-position; i++) {
                        search = search.next;
                    }
                    c2.random = search;
                }
            }
            position++;
            c1 = c1.next;
            c2 = c2.next;
        }
        
        return solution;
    }
}