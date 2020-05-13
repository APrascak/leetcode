// Remove Duplicates from Sorted Array
// 19 Feb 2020

// O(n) solution updated 13 May 2020
class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 0, r = 1;
        while (r < nums.length) {
            if (nums[r] != nums[l]) {
                l++;
                nums[l] = nums[r];
            }
            r++;
        }
        return l+1;
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int position = 1;
        int currValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != currValue) {
                currValue = nums[i];
                nums[position] = currValue;
                position++;
            }
        }
        return position;
    }
}