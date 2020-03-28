// Isomorphic Strings
// 28 March 2020

class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> mapS = new HashMap<Character, Integer>();
        HashMap<Character, Integer> mapT = new HashMap<Character, Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            if (mapS.containsKey(s.charAt(i)) && mapT.containsKey(t.charAt(i))) {
                if (mapS.get(s.charAt(i)) != mapT.get(t.charAt(i)) ) {
                    return false;
                }
            } else if ( !(mapS.containsKey(s.charAt(i))) && !(mapT.containsKey(t.charAt(i)))) {
                mapS.put(s.charAt(i), i);
                mapT.put(t.charAt(i), i);
            } else {
                return false;
            }
        }
        
        return true;
    }
}