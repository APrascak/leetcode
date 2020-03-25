// Contains Duplicate
// 25 March 2020

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            }
            map.put(nums[i],0);
        }
        return false;
    }
}