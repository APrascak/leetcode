// Smallest Range I
// 21 April 2020

class Solution {
    public int smallestRangeI(int[] A, int K) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }
        int result = (max - K) - (min + K);
        if (result < 0) return 0;
        return result;
    }
}