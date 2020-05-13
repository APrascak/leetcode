// Add Two Numbers
// 9 March 2020

// O(n) solution updated 13 May 2020
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        helper(0,l1,l2);
        return l1;
    }
    
    private ListNode helper(int carry, ListNode a, ListNode b) {
        if (a == null && b == null) {
            if (carry == 1) {
                a = new ListNode(1);
                return a;
            } else {
                return null;
            }
        } else if (a == null) {
            a = new ListNode(b.val+carry);
            if (a.val > 9) {
                a.val %= 10;
                a.next = helper(1, a.next, b.next);
                return a;
            } else {
                a.next = helper(0, a.next, b.next);
                return a;
            }
        } else if (b == null) {
            a.val += carry;
            if (a.val > 9) {
                a.val %= 10;
                a.next = helper(1, a.next, null);
                return a;
            } else {
                a.next = helper(0, a.next, null);
                return a;
            }
        } else {
            a.val += b.val + carry;
            if (a.val > 9) {
                a.val %= 10;
                a.next = helper(1, a.next, b.next);
                return a;
            } else {
                a.next = helper(0, a.next, b.next);
                return a;
            }
        }
    }
}