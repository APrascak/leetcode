// Longest Substring with At Most K Distinct Characters
// 1 June 2020

// O(n) time, O(n) space
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, l = 0, ans = 0;
        while (i < s.length()) {
            char curr = s.charAt(i);
            map.put(curr, map.getOrDefault(curr, 0) +1);
            while (map.size() > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                if (map.get(s.charAt(l)) == 0)
                    map.remove(s.charAt(l));
                l++;
            }
            ans = Math.max(ans, i-l+1);
            i++;
        }
        ans = Math.max(ans, i - l);
        return ans;
    }
}