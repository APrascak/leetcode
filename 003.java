// Longest Substring Without Repeating Characters
// 29 March 2020

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int length = 0, curr = 0;
        for(int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (map.containsKey(letter)) {
                int diff = i - map.get(letter);
                if (diff <= curr) {
                    curr = diff;
                } else {
                    curr++;
                }
                map.put(letter, i);
                length = Math.max(length, curr);
            } else {
                curr++;
                map.put(letter, i);
                length = Math.max(length, curr);
            }
        }
        return length;
    }
}