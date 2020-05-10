// Valid Mountain Array
// 9 May 2020

class Solution {
    public boolean validMountainArray(int[] A) {
        if (A.length == 0 || A.length == 1 || A[0] >= A[1])
            return false;
        int i = 1;
        while (i < A.length) {
            if (A[i] == A[i-1]) {
                return false;
            } else if (A[i] > A[i-1]) {
                i++;
            } else {
                break;
            }
        }
        if (i == A.length)
            return false;
        while (i < A.length) {
            if (A[i] == A[i-1]) {
                return false;
            } else if (A[i] < A[i-1]) {
                i++;
            } else {
                return false;
            }
        }
        return true;
    }
}