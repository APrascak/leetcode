// Trapping Rain Water
// 13 May 2020

// O(n) time O(n) space
class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            left[i] = max;
            max = Math.max(max, height[i]);
        }
        max = 0;
        for (int i = height.length-1; i>=0; i--) {
            right[i] = max;
            max = Math.max(max, height[i]);
        }
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            if (Math.min(left[i], right[i]) - height[i] > 0)
                sum += Math.min(left[i], right[i]) - height[i];
        }
        return sum;
    }
}

// O(n) time O(1) space
class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;
        while (l < r) {
            if (height[l] <= height[r]) {
                leftMax = Math.max(leftMax, height[l]);
                if (height[l] < leftMax)
                    water += (leftMax-height[l]);
                l++;
            } else {
                rightMax = Math.max(rightMax, height[r]);
                if (height[r] < rightMax)
                    water += (rightMax-height[r]);
                r--;
            }
        }
        return water;
    }
}