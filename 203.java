// Remove Linked List Elements
// 25 Feb 2020

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            if (head.val == val) {
                return null;
            } else {
                return head;
            }
        }
        while (head.val == val) {
            head = head.next;
            if (head == null) { return null; }
        }
        if (head.next == null) {
            return head;
        }
        ListNode check = head.next;
        ListNode curr  = head;
        while (check != null) {
            if (check.val == val) {
                curr.next = check.next;
                check = check.next;
            } else {
                check = check.next;
                curr = curr.next;
            }
        }
        return head;
    }
}