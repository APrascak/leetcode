// Kids With the Greatest Number of Candies
// 3 May 2020

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        
        for (int num : candies)
            max = Math.max(max, num);
        
        List<Boolean> solution = new ArrayList<>();
        for (int num : candies) {
            solution.add((num+extraCandies) >= max);
        }
        
        return solution;
    }
}