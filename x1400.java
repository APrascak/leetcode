// Construct K Palindrome Strings
// 4 April 2020

class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        if (k > n) return false;
        
        Map<Character, Integer> map = new HashMap<>();
        for (char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) +1);
        }
        
        int countOnes = 0;
        
        for (Character c : map.keySet()) {
            if ((map.get(c) % 2) == 1) countOnes++;
        }
        
        return (countOnes <= k);
    }
}