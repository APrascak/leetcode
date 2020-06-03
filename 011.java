// Container With Most Water
// 2 June 2020

// O(n) time, O(1) space
class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length-1, answer = 0;;
        while (l < r) {
            int a = height[l];
            int b = height[r];
            answer = Math.max(answer, Math.min(a,b) * (r-l));
            if (a <= b) {
                l++;
            } else {
                r--;
            }
        }
        return answer;
    }
}