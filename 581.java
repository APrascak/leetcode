// Shortest Unsorted Continuous Subarray
// 22 April 2020

// O(NlogN) solution
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] copy = new int[n];
        
        for (int i = 0; i < n; i++) {
            copy[i] = nums[i];
        }
        
        Arrays.sort(copy);
        
        int first = -1;
        int last = -2;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] != copy[i]) {
                if (first == -1) {
                    first = i;
                } else {
                    last = i;
                }
            }
        }
        
        return (last - first) + 1;
        
    }
}

// O(N) solution with O(1) extra space - could not come up with this
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean flagged = false;
        
        for (int i = 1; i < n; i++) {
            if (nums[i-1] > nums[i]) flagged = true;
            if (flagged) min = Math.min(min, nums[i]);
        }
        
        flagged = false;
        for (int i = n-2; i >= 0; i--) {
            if (nums[i] > nums[i+1]) flagged = true;
            if (flagged) max = Math.max(max, nums[i]);
        }
        
        int start = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > min) {
                start = i;
                break;
            }
        }
        
        int end = -1;
        for (int i = n-1; i >= 0; i--) {
            if (nums[i] < max) {
                end = i;
                break;
            }
        }
        
        if (flagged == false) return 0;
        return end - start + 1;
        
    }
}