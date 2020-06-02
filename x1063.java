// Number of Valid Subarrays
// 2 June 2020

// O(n^2) time, O(1) space
class Solution {
    public int validSubarrays(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            count++;
            for (int j = i+1; j < n; j++) {
                if (nums[j] < nums[i])
                    break;
                count++;
            }
        }
        return count;
    }
}

// O(n) time, O(n) space
class Solution {
    public int validSubarrays(int[] nums) {
        int n = nums.length;
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] < stack.peek())
                stack.pop();
            stack.push(nums[i]);
            count += stack.size();
        }
        return count;
    }
}