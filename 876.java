// Middle of the Linked List
// 12 March 2020

class Solution {
    public ListNode middleNode(ListNode head) {
        
        if (head == null) { return head; }
        
        ListNode fast = head.next;
        ListNode slow = head;
        
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return slow;
    }
}