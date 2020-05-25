// Uncrossed Lines
// 25 May 2020

// O(m*n) time, O(m*n) space
class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int[][] dp = new int[A.length][B.length];
        // Calculate intersections
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j])
                    dp[i][j] = 1;
            }
        }
        // Solve top row
        for (int i = 1; i < B.length; i++) {
            dp[0][i] = Math.max(dp[0][i], dp[0][i-1]);
        }
        // Solve left column
        for (int i = 1; i < A.length; i++) {
            dp[i][0] = Math.max(dp[i][0], dp[i-1][0]); 
        }
        // Solve rest of arrays
        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j < B.length; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1]+dp[i][j], Math.max(dp[i-1][j], dp[i][j-1]));
            }
        }
        return dp[A.length-1][B.length-1];
    }
}

// Recursive solution: Time Limit Exceeded
class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        return helper(A,B,0);
    }
    
    private int helper(int[] A, int[] B, int sum) {
        if (B.length == 0 || A.length == 0)
            return sum;
        int curr = A[0];
        int max = 0;
        for (int i = 0; i < B.length; i++) {
            if (B[i] == curr) {
                max = Math.max(max, helper(Arrays.copyOfRange(A,1,A.length), Arrays.copyOfRange(B,i+1,B.length), sum+1));
            }
        }
        return Math.max(max, helper(Arrays.copyOfRange(A,1,A.length), B, sum));
    }
}