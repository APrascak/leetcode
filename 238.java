// Product of Array Except Self
// 3 April 2020

// O(N) space complexity: creates arrays for left and right
class Solution {
    public int[] productExceptSelf(int[] nums) {        
        int n = nums.length;
        int[] r = new int[n];
        int[] l = new int[n];
        
        // create right products
        int product = 1;
        for (int i = n-1; i >= 0; i--) {
            r[i] = product;
            product *= nums[i];
        }
        
        // create left products
        product = 1;
        for (int i = 0; i < n; i++) {
            l[i] = product;
            product *= nums[i];
        } 
        
        // move left and right products back into nums
        for (int i = 0; i < n; i++) {
            nums[i] = l[i] * r[i];
        }
        
        return nums;
    }
}

// O(1) Space complexity: stores left products in ans and re-iterates calculating the right sum
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int product = 1;
        for (int i = 0; i<n; i++) {
            ans[i] = product;
            product *= nums[i];
        }

        product = 1;
        for (int i = n-1; i >= 0; i--) {
            ans[i] *= product;
            product *= nums[i];
        }
        return ans;
    }
}