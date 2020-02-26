// Odd Even Linked List
// 26 Feb 2020

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) { return null; }
        if (head.next == null) { return head; }
        if (head.next.next == null) { return head; }
        
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            ListNode temp = slow.next;
            slow.next = fast.next;
            fast.next = fast.next.next;
            slow.next.next = temp;
            slow = slow.next;
            fast = fast.next;
            ListNode print = head;
            if (fast != null) {
                if (fast.next == null) { return head; }
            }
        }
        return head;
    }
}