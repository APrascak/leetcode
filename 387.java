// First Unique Character in a String
// 28 March 2020

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (map.containsKey(letter)) {
                int updatedCount = map.get(letter) + 1;
                map.put(letter, updatedCount);
            } else {
                map.put(letter, 1);
            }
        }
        
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (map.get(letter) == 1) {
                return i;
            }
        }
        return -1;
    }
}