// Number of Equivalent Domino Pairs
// 4 April 2020

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> map = new HashMap<>();
        int pairs = 0;
        for (int i = 0; i < dominoes.length; i++) {
            if (dominoes[i][0] > dominoes[i][1]) {
                int temp = dominoes[i][0];
                dominoes[i][0] = dominoes[i][1];
                dominoes[i][1] = temp;
            }
            String temp = dominoes[i][0] + "," + dominoes[i][1];
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            pairs += map.get(temp) - 1;
        }
        return pairs;
    }
}