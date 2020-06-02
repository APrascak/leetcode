// Longest Increasing Subsequence
// 1 June 2020

// O(n^2) time, O(n) space
class Solution {
    public int lengthOfLIS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        for (int num : nums) {
            int curr = 1;
            for (int key : map.keySet()) {
                if (key < num) {
                    curr = Math.max(curr, map.get(key) + 1);
                }
            }
            map.put(num, curr);
            answer = Math.max(answer, curr);
        }
        return answer;
    }
}