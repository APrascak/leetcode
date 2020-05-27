// Random Pick Index
// 27 May 2020

// O(n) initialization time & space
// O(1) access time
class Solution {
    Map<Integer, List<Integer>> map;

    public Solution(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(nums[i], temp);
            }
        }
    }
    
    public int pick(int target) {
        int index = 0 + (int) (Math.random() * map.get(target).size());
        return map.get(target).get(index);
    }
}
