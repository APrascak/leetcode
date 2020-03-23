// Height Checker
// 23 March 2020

class Solution {
    public int heightChecker(int[] heights) {
        
        int[] original = new int[heights.length];
        for (int i =0; i<original.length;i++) {
            original[i] = heights[i];
        }
        Arrays.sort(heights);
        int count = 0;
        
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != original[i]) {
                count++;
            }
        }
        
        return count;
    }
}