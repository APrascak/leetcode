// Missing Number
// 1 April 2020

class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> seen = new HashSet<Integer>();
        int n = nums.length;
        for (int x : nums) {
            seen.add(x);
        }
        for (int i = 0; i <= n; i++) {
            if (!seen.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}