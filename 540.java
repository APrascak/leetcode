// Single Element in a Sorted Array
// 12 May 2020

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            System.out.println(lo+" "+hi+" "+mid);
            if (nums[mid] == nums[mid-1]) {
                if ((mid - lo) % 2 == 1) {
                    lo = mid+1;
                } else {
                    hi = mid-2;
                }
            } else if (nums[mid] == nums[mid+1]) {
                if ((mid - lo) % 2 == 0) {
                    lo = mid+2;
                } else {
                    hi = mid-1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[hi];
    }
}