// Missing Number
// 1 April 2020

// O(n) time O(1) space: 25 May 2020
class Solution {
    public int missingNumber(int[] nums) {
        int total = 0, curr = 0;
        for (int i = 0; i < nums.length; i++) {
            total += i+1;
            curr += nums[i];
        }
        return total - curr;
    }
}

// O(n) time O(n) space
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