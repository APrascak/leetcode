// Search Insert Position
// 24 May 2020

// O(logN) time and O(1) space
class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while (l <= r) {
            int mid = (l+r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        if (target < nums[0])
            return 0;
        return r+1;
    }
}