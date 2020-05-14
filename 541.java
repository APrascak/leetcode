// Reverse String II
// 13 May 2020

class Solution {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        int i = 0;
        while (i < ch.length) {
            int l = i, r = i+k-1;
            if (r >= ch.length)
                r = ch.length-1;
            while (l < r) {
                char temp = ch[l];
                ch[l] = ch[r];
                ch[r] = temp;
                l++;
                r--;
            }
            i += k;
            i += k;
        }
        return String.valueOf(ch);
    }
}