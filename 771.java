// Jewels and Stones
// 29 March 2020

class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> hashSet = new HashSet<Character>();
        int ans = 0;
        
        for (char x : J.toCharArray()) {
            hashSet.add(x);
        }
        
        for (char y : S.toCharArray()) {
            if (hashSet.contains(y)){
                ans++;
            }
        } 
        
        return ans;
    }
}