// Flipping an Image
// 30 April 2020

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        // printArray(A);
        for (int i = 0; i < A.length; i++) {
            int lo = 0;
            int hi = A[i].length -1;
            while (lo <= hi) {
                int temp = A[i][lo];
                A[i][lo] = A[i][hi];
                A[i][hi] = temp;
                lo++;
                hi--;
            }
        }
        // printArray(A);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == 1) {
                    A[i][j] = 0;
                } else {
                    A[i][j] = 1;
                }
            }
        }
        // printArray(A);
        return A;
    }
    
    private void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("------");
    }
}