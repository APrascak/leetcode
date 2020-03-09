// Merge Two Sorted Lists
// 9 March 2020

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        
        if (l1.next == null && l2.next == null) {
            if (l1.val <= l2.val) {
                l1.next = l2;
                return l1;
            } else {
                l2.next = l1;
                return l2;
            }
        }
        
        ListNode c1;
        ListNode c2;
        ListNode prior;
        
        if (l1.val <= l2.val) {
            c1 = l1;
            c2 = l2;
        } else {
            c1 = l2;
            c2 = l1;
        }
        prior = c1;
        c1 = c1.next;
        
        while (c1 != null && c2 != null) {
            if (c2.val <= c1.val) {
                prior.next = c2;
                ListNode temp = c2.next;
                c2.next = c1;
                prior = c2;
                c2 = temp;
            } else {
                while (c2.val > c1.val) {
                    c1 = c1.next;
                    prior = prior.next;
                    if (c1 == null) {
                        break;
                    }
                }
            }
        }
        //System.out.println(c1.val);
        //System.out.println(c2.val);
        
        if (c1 == null) {
            prior.next = c2;
        }
        
        if (l1.val <= l2.val) {
            return l1;
        } else {
            return l2;
        }
                
    }
}