// Two City Scheduling
// 6 May 2020

// O(n^2) time and O(n^2) space
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int[][] dp = new int[(costs.length  / 2) + 1][(costs.length / 2) + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[0][i] = dp[0][i-1] + costs[i-1][0];
            dp[i][0] = dp[i-1][0] + costs[i-1][1];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = Math.min(costs[i+j-1][0] + dp[i][j-1], costs[i+j-1][1] + dp[i-1][j]);
            }
        }
        return dp[dp.length-1][dp.length-1];
    }
    
    private void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}