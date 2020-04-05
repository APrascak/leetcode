// Minimum Subsequence in Non-Increasing Order
// 4 April 2020

class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int right = 0;
        for (int i = n-1; i >= 0; i--) {
            right += nums[i];
            sum -= nums[i];
            ans.add(nums[i]);
            if (right > sum) return ans;
        }
        return ans;
    }
}