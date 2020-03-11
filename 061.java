// Rotate List
// 10 March 2020

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) { return head; }
        
        ListNode ref = head;
        ListNode curr = head;
        ListNode solution;
        int length = 1;
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }
        if (length == k) { return head; }
        curr.next = head;
        for (int i = 0; i < length - 1 - (k % length); i++) {
            ref = ref.next;
        }
        solution = ref.next;
        ref.next = null;

        return solution;
    }
}