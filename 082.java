// Remove Duplicates from Sorted List II
// 4 April 2020

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode ref = new ListNode(0);
        ListNode curr = head;
        ref.next = curr;
        ListNode ans = ref;
        while (curr != null) {
            while (curr.val == ref.next.val) {
                curr = curr.next;
                if (curr == null) break;
            }
            if (ref.next.next == curr) {
                ref = ref.next;
            } else {
                ref.next = curr;
            }
        }
        return ans.next;
    }
}