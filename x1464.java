// Maximum Product of Two Elements in an Array
// 1 June 2020

// O(n) time, O(1) space
class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0], ans = 0;
        for (int i = 1; i < nums.length; i++) {
            ans = Math.max(ans, (nums[i]-1) * (max-1));
            max = Math.max(max, nums[i]);
        }
        return ans;
    }
}