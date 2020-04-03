// Swap Nodes in Pairs
// 3 April 2020

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        return swap(head);
    }
    
    public ListNode swap(ListNode c) {
        if (c == null || c.next==null) return c;
        ListNode ref = c.next.next;
        c.next.next = c;
        c = c.next;
        c.next.next = swap(ref);
        return c;
    }
}