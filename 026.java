// Remove Duplicates from Sorted Array
// 19 Feb 2020

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