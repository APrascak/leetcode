// Longest Common Prefix
// 10 Feb 2020

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        
        StringBuilder answer = new StringBuilder();
        int min = strs[0].length();
        for (String str : strs) {
            if (str.length() < min) {
                min = str.length();
            }
        }
        
        
        boolean endPrefix = false;
        for (int i = 0; i < min; i++) {
            char x = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) != x) {
                    endPrefix = true;
                    break;
                }
            }
            
            if (endPrefix) {
                break;
            } else {
                answer.append(x);
            }
        }
        
        return answer.toString();
    }
}