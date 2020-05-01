// Search a 2D Matrix II
// 30 April 2020

// DP solution: I think O(mn) space and time
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        boolean[][] dp = new boolean[matrix.length][matrix[0].length];
        return helper(matrix, target, 0, 0, dp);
    }
    
    private boolean helper(int[][] matrix, int target, int row, int col, boolean[][] dp) {
        if (row >= matrix.length || col >= matrix[0].length) return false;
        if (dp[row][col]) return false;
        int value = matrix[row][col];
        if (value == target) return true;
        if (value < target) {
            boolean ans = helper(matrix, target, row+1, col, dp) || helper(matrix, target, row, col+1, dp);
            if (!ans) dp[row][col] = true;
            return ans;
        }
        dp[row][col] = true;
        return false;
    }
}

// Iterative solution O(m+n) time O(1) space
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int row = matrix.length - 1; // start from bottom left corner
        int col = 0;
        while (col < matrix[0].length && row >= 0) {
            if (matrix[row][col] < target) {
                col++;
            } else if (matrix[row][col] > target) {
                row--;
            } else {
                return true;
            }
        }
        return false;
    }

}