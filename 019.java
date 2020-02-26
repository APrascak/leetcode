// Remove Nth Node from End of List
// 25 Feb 2020

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int length = 0;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        
        if (length == 0) {
            return null;
        }
        if (length == 1) {
            return null;
        }
        if (length == n) {
            head = head.next;
            return head;
        }
        
        curr = head;
        for(int i = 0; i < length - n - 1; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }
}