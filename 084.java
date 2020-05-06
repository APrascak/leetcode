// Largest Rectangle in Histogram
// 5 May 2020

// Brute-force O(n^2) time O(1) space
class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int min = heights[i];
            for (int j = i; j >= 0; j--) {
                min = Math.min(min, heights[j]);
                max = Math.max(max, min*(i-j+1));
            }
        }
        return max;
    }
}