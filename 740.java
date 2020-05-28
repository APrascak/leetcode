// Delete and Earn
// 27 May 2020

// O(n) time, O(n) space
class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + num);
        int[] values = new int[map.size()];
        int pos = 0;
        for (int num : map.keySet()) {
            values[pos] = num;
            pos++;
        }
        int[] dp = new int[values.length+1];
        dp[0] = 0;
        dp[1] = map.get(values[0]);
        for (int i = 1; i < values.length; i++) {
            if (values[i] == values[i-1] + 1) {
                dp[i+1] = Math.max(dp[i], dp[i-1]+map.get(values[i]));
            } else {
                dp[i+1] = dp[i] + map.get(values[i]);
            }
        }
        return dp[values.length];
    }
}