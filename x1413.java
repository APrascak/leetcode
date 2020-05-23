// Minimum Value to Get Positive Step by Step Sum
// 22 May 2020

// O(n) time and O(1) space 
class Solution {
    public int minStartValue(int[] nums) {
        int min = Integer.MAX_VALUE;
        int curr = 0;
        for (int num : nums) {
            curr += num;
            min = Math.min(min, curr);
        }
        if ((min * -1) + 1 < 1)
            return 1;
        return (min*-1)+1;
    }
}