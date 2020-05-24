// Max Dot Product of Two Subsequences
// 24 May 2020

// O(m*n) time and space
class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] products = new int[nums1.length][nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                products[i][j] = nums1[i] * nums2[j];
            }
        }
        //printMatrix(products);
        int[][] dp = new int[products.length][nums2.length];
        dp[nums1.length-1][nums2.length-1] = products[nums1.length-1][nums2.length-1];
        for (int i = dp.length-2; i >= 0; i--) {
            dp[i][nums2.length-1] = Math.max(products[i][nums2.length-1], dp[i+1][nums2.length-1]);
        }
        //printMatrix(dp);
        for (int i = nums2.length-2; i >= 0; i--) {
            dp[nums1.length-1][i] = Math.max(products[nums1.length-1][i], dp[nums1.length-1][i+1]);
        }
        //printMatrix(dp);
        for (int i = nums1.length-2; i >= 0; i--) {
            for (int j = nums2.length-2; j >= 0; j--) {
                dp[i][j] = Math.max(Math.max(products[i][j]+dp[i+1][j+1],products[i][j]), Math.max(dp[i+1][j],dp[i][j+1]));
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        //printMatrix(dp);
        return max;
    }
    
    private void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}