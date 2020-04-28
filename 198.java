// House Robber
// 27 April 2020

// Recursion with DP O(n) with O(n) memory
class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        return helper(nums, 0, dp);
    }
    
    public int helper(int[] nums, int i, int[] dp) {
        if (i >= nums.length) return 0;
        if (dp[i] >= 0) return dp[i];
        int max = Math.max(helper(nums, i+2, dp) + nums[i], helper(nums, i+1, dp));
        dp[i] = max;
        return dp[i];
    }
}

// DP O(n) with O(n) memory
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i+1] = Math.max(dp[i-1] + nums[i], dp[i]);
        }
        return dp[nums.length];
    }
}

// DP O(n) with O(1) memory
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = x;
            x = y;
            y = Math.max(temp + nums[i], x);
        }
        return y;
    }
}