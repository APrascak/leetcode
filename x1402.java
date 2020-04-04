// Reducing Dishes
// 4 April 2020

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = i; j < n; j++) {
                temp += satisfaction[j] * (j-i+1);
            }
            max = Math.max(max, temp);
        }
        if (max < 0) return 0;
        return max;
    }
}