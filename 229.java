// Majority Elements II
// 27 Feb 2020

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int req = nums.length / 3;
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> solution = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.replace(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) > req) {
                solution.add(key);
            }
        }
        return solution;
    }
}