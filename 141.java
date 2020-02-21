// Linked List Cycle
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
    public boolean hasCycle(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        
        while (fastNode != null) {
            fastNode = fastNode.next;
            
            if (fastNode == slowNode) {
                return true;
            } else {
                slowNode = slowNode.next;
                if (fastNode != null) {
                    fastNode = fastNode.next;
                }
            }
        }
        
        return false;
    }
}