// Reverse Linked List
// 25 Feb 2020

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            ListNode temp = head.next;
            temp.next = head;
            head.next = null;
            head = temp;
            return head;
        }
        ListNode curr = head.next;
        ListNode past = head;
        ListNode future = head.next.next;
        while (future != null) {
            System.out.println("curr: " + curr.val);
            curr.next = past;
            past = curr;
            curr = future;
            future = future.next;
        }
        curr.next = past;
        head.next = null;
        head = curr;
        return head;
        
    }
}