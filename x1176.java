// Diet Plan Performance
// 13 May 2020

// O(n) time O(1) space
class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int sum = 0, score = 0;
        for (int i = 0; i < k; i++)
            sum += calories[i];
        score += score(sum,lower,upper);
        for (int i = k; i < calories.length; i++) {
            sum = sum + calories[i] - calories[i-k];
            score += score(sum,lower,upper);
        }
        return score;
    }
    
    private int score(int sum, int lower, int upper) {
        if (sum < lower)
            return -1;
        if (sum > upper)
            return 1;
        return 0;
    }
}