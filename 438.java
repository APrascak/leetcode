// Find All Anagrams in a String
// 3 April 2020

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        
        Map<Character, Integer> map = new HashMap<>();
        for (char x : p.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        
        int counter = map.size();
        int curr = 0, prev = 0;
        int len = p.length();
        
        while (curr < len) {
            char x = s.charAt(curr);
            if (map.containsKey(x)) {
                map.put(x, map.get(x) - 1);
                if (map.get(x) == 0) counter--;
            }
            curr++;
            
            while (counter == 0) {
                char y = s.charAt(prev);
                if (map.containsKey(y)) {
                    map.put(y, map.get(y)+1);
                    if (map.get(y) > 0) counter++;
                }
                if (end-begin == len) ans.add(prev);
                prev++;
            }
        }
        
        return ans;
    }
}