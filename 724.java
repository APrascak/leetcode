// Find Pivot Index
// Jan 2020

class Solution {
    public int pivotIndex(int[] nums) {
        
        int right_side = 0;
        int left_side  = 0;
        int n = nums.length;
        int pivot = 0;
        
        if (n == 0) {
            return -1;
        }
        
        // Establish total to right of pivot
        for (int i = 1; i < n; i++) {
            right_side += nums[i];
        }
        
        if ( n==1 || right_side == left_side) {
            return 0;
        }
        
        // Search for pivot
        while ( pivot < n-1) {
            pivot++;
            left_side  += nums[pivot - 1];
            right_side -= nums[pivot];
            if (left_side == right_side) {
                return pivot;
            }
        }
        
        return -1;
    }
}