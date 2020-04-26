// Jump Game
// 26 April 2020

class Solution {
    public boolean canJump(int[] nums) {
        return jumpRecursion(nums, 0, new boolean[nums.length]);
    }
    
    public boolean jumpRecursion(int[] arr, int pos, boolean[] dp) {
        if (pos == arr.length - 1) return true;
        if (pos >= arr.length || arr[pos] == 0) return false;
        if (dp[pos] == true) return false;
        for (int i = 1; i <= arr[pos]; i++) {
            if (jumpRecursion(arr, pos+i, dp)) return true;
            dp[pos] = true;
        }
        return false;
    }
}