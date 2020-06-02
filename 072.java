// Edit Distance

// O(n^2) time, O(n^2) space
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++)
            dp[i][0] = 1 + dp[i-1][0];
        for (int i = 1; i <= n; i++)
            dp[0][i] = 1 + dp[0][i-1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c1 = word1.charAt(i-1);
                char c2 = word2.charAt(j-1);
                if (c1 == c2) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
    
    private void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("-----");
    }
}