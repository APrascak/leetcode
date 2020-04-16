// Add Two Numbers II
// 15 April 2020

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0) return l2;
        ListNode curr = l1;
        int lengthOne = 0, lengthTwo = 0;
        while (curr != null) {
            lengthOne++;
            curr = curr.next;
        }
        curr = l2;
        while (curr != null) {
            lengthTwo++;
            curr = curr.next;
        }
        int carry = 0;
        if (lengthOne > lengthTwo) {
            curr = l2;
            for (int i = 0; i < lengthOne - lengthTwo; i++) {
                ListNode temp = new ListNode(0);
                temp.next = curr;
                curr = temp;
            }
            carry = add(l1, curr);
            if (carry == 1) {
                ListNode temp = new ListNode(1);
                temp.next = l1;
                return temp;
            }
            return l1;
        } else if (lengthTwo > lengthOne) {
            curr = l1;
            for (int i = 0; i < lengthTwo - lengthOne; i++) {
                ListNode temp = new ListNode(0);
                temp.next = curr;
                curr = temp;
            }
            carry = add(curr, l2);
            if (carry == 1) {
                ListNode temp = new ListNode(1);
                temp.next = curr;
                return temp;
            }
            return curr;
        } else {
            carry = add(l1, l2);
            if (carry == 1) {
                ListNode temp = new ListNode(1);
                temp.next = l1;
                return temp;
            }
            return l1;
        }
    }
    
    public int add(ListNode a, ListNode b) {
        if (a == null || b == null) return 0;
        a.val += b.val + add(a.next, b.next);
        if (a.val >= 10) {
            a.val = a.val % 10;
            return 1;
        } else {
            return 0;
        }
    }
}