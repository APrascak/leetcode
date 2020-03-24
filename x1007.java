// Minimum Domino Rotations For Equal Row
// 24 March 2020

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        
        if (A.length == 1) { return 0; }
        
        int topCount = 0;
        int bottomCount = 0;
        int constant = -1;
        // find common value in first 2 elements
        if (A[0] == A[1] || A[0] == B[1]) {
            constant = A[0];
        }
        if (B[0] == A[1] || B[0] == B[1]) {
            constant = B[0];
        }
        if ((B[0] == A[1] || B[0] == B[1]) && (A[0] == A[1] || A[0] == B[1])) {
            int constantTwo = A[0];
            int secondTopCount = 0;
            int secondBottomCount = 0;
            boolean twoValid = true;
            int secondMax;
            
            for (int i = 0; i < A.length; i++) {
                if (A[i] != constantTwo) {
                    secondTopCount++;
                }
                if (B[i] != constantTwo) {
                    secondBottomCount++;
                }
                if (A[i] != constantTwo && B[i] != constantTwo) {
                    twoValid = false;
                }
            }
            secondMax = Math.min(secondTopCount, secondBottomCount);
            
            boolean oneValid = true;
            int oneMax;
            for (int i = 0; i < A.length; i++) {
                if (A[i] != constant) {
                    topCount++;
                }
                if (B[i] != constant) {
                    bottomCount++;
                }
                if (A[i] != constant && B[i] != constant) {
                    oneValid = false;
                }
            }
            oneMax = Math.min(topCount, bottomCount);

            if (oneValid && twoValid) {
                return Math.min(oneMax, secondMax);
            } else if (oneValid) {
                return oneMax;
            } else if (twoValid) {
                return secondMax;
            } else {
                return -1;
            }
        }
        if (constant == -1) { return constant; }
        
        // if top = element then top is the value
        // if bottom = elment then bottom count increases
        // else return false
        for (int i = 0; i < A.length; i++) {
            if (A[i] != constant) {
                topCount++;
            }
            if (B[i] != constant) {
                bottomCount++;
            }
            if (A[i] != constant && B[i] != constant) {
                return -1;
            }
        }
        
        return Math.min(topCount, bottomCount);
    }
}