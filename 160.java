// Intersection of Two Linked Lists
// 20 Feb 2020

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// Brute-Force Solution
// O(m*n)
// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         ListNode currA = headA;
//         ListNode currB = headB;
        
//         while (currA != null) {
//             currB = headB;
//             while (currB != null) {
//                 if (currB == currA) {
//                     return currA;
//                 } else {
//                     currB = currB.next;
//                 }
//             }
//             currA = currA.next;
//         }
//         return null;
//     }
// }

// Two-Pointer Solution: much more optimal
// O(m+n)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;
        int countA = 0;
        int countB = 0;
        
        while (currA != null) {
            countA++;
            currA = currA.next;
        }
        while (currB != null) {
            countB++;
            currB = currB.next;
        }
        
        currA = headA;
        currB = headB;
        
        if (countB > countA) {
            for (int i = 0; i < countB-countA; i++) {
                currB = currB.next;
            }
        } else if (countA > countB) {
            for (int i = 0; i < countA-countB; i++) {
                currA = currA.next;
            }
        }
        
        while (currA != null || currB != null) {
            if (currA == currB) {
                return currA;
            }
            currA = currA.next;
            currB = currB.next;
        }
        return null;
    }
}