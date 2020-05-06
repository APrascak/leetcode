// Majority Element
// 6 May 2020

// O(n) time & space
class Solution {
    public int majorityElement(int[] nums) {
        int majority = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > majority) return num;
        }
        return -1;
        
    }
}