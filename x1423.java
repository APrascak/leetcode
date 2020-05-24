// Maximum Points You Can Obtain from Cards
// 23 May 2020

// O(k) time and O(1) space
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int max = 0;
        int curr = 0;
        for (int i = 0; i < k; i++) {
            curr += cardPoints[i];
        }
        max = Math.max(max, curr);
        int l = k-1, r = cardPoints.length -1;
        while (l >= 0) {
            curr = curr - cardPoints[l] + cardPoints[r];
            l--;
            r--;
            max = Math.max(max, curr);
        }
        return max;
    }
}