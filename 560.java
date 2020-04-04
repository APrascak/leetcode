// Subarray Sum Equals K
// 3 April 2020

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int curr = 0, prev = 0, count = 0, total = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            total += nums[i];
            if (map.containsKey(total - k)) count += map.get(total-k);
            if (total == k) count++;
            map.put(total, map.getOrDefault(total, 0) + 1);
        }
        return count;
    }
}