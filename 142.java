// Linked List Cycle II
// 20 Feb 2020

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            
            if (fast == slow) {
                ListNode slowAgain = head;
                while (slowAgain != slow) {
                    slow = slow.next;
                    slowAgain = slowAgain.next;
                }
                return slow;
            }
        }
        return null;
    }
}