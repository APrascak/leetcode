// Contains Duplicate II
// 28 March 2020

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int value = nums[i];
            if (map.containsKey(value)) {
                if (i - map.get(value) <= k) {
                    return true;
                }
            }
            map.put(value, i);
        }
        return false;
    }
}