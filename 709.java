// To Lower Case
// 4 May 2020

class Solution {
    public String toLowerCase(String str) {
        String ans = "";
        for (int i = 0; i < str.length(); i++) {
            char ref = str.charAt(i);
            if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z')
                ref = (char) (str.charAt(i) - 'A' + 'a');
            ans += ref;
        }
        return ans;
    }
}