// Pairs of Songs With Total Durations Divisible by 60
// 4 May 2020

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : time) {
            int complement = 60 - (num % 60);
            if (complement == 60) complement = 0;
            if (map.containsKey(complement))
                count += map.get(complement);
            map.put(num % 60, map.getOrDefault(num % 60, 0) + 1);
        }
        return count;
    }
}