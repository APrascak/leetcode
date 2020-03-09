// Add Two Numbers
// 9 March 2020

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int count1 = 0;
        int count2 = 0;
        
        ListNode c1 = l1;
        ListNode c2 = l2;
        
        while (c1 != null) {
            count1++;
            c1 = c1.next;
        }
        while (c2 != null) {
            count2++;
            c2 = c2.next;
        }
        
        ListNode solution;
        if (count1 < count2) {
            c1 = l2;
            c2 = l1;
            solution = l2;
        } else {
            c1 = l1;
            c2 = l2;
            solution = l1;
        }
        
        
        if (l1 == null) { return l2; }
        if (l2 == null) { return l1; }
        
        System.out.println(c2.val);
        while (c2 != null) {
            c1.val += c2.val;
            if (c1.val >= 10) {
                if (c1.next == null) {
                    ListNode temp = new ListNode(1);
                    c1.val -= 10;
                    c1.next = temp;
                    return l1;
                } else {
                    c1.next.val++;
                    c1.val-=10;
                }
            }
            c1 = c1.next;
            c2 = c2.next;
        }
        
        ListNode print = solution;
        while (print != null) {
            System.out.print(print.val + " ");
            print = print.next;
        }
        
        while (c1 != null) {
            if (c1.val >= 10) {
                if (c1.next == null) {
                    ListNode temp = new ListNode(1);
                    c1.next = temp;
                } else {
                    c1.next.val++;
                }
                c1.val-=10;
            }
            c1 = c1.next;
        }
        
        
        
        return solution;
    }
}