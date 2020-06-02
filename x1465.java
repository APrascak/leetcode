// Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
// 1 June 2020

// O(n*logn) time, O(1) space
class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int prev = 0, maxH = 0;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        for (int cuts : horizontalCuts) {
            maxH = Math.max(maxH, cuts-prev);
            prev = cuts;
        }
        maxH = Math.max(maxH, h - prev);
        prev = 0;
        int maxW = 0;
        for (int cut : verticalCuts) {
            maxW = Math.max(maxW, cut - prev);
            prev = cut;
        }
        maxW = Math.max(maxW, w - prev);
        return (int) ((long)maxW * maxH % 1000000007);
    }
}