// Squares of a Sorted Array
// 15 April 2020

class Solution {
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] answer = new int[n];
        int left = 0, right = n-1;
        int placement = n-1;
        while (left <= right && placement >= 0) {
            if (Math.abs(A[left]) < Math.abs(A[right])) {
                answer[placement] = A[right] * A[right];
                right--;
            } else {
                answer[placement] = A[left] * A[left];
                left++;
            }
            placement--;
        }
        return answer;
    }
}