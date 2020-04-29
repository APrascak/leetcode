// Reverse Vowels of a String
// 28 April 2020

class Solution {
    public String reverseVowels(String s) {
        int l = 0;
        int r = s.length() - 1;
        char[] ch = s.toCharArray();
        String vowels = "aeiou";
        while (l < s.length() && r >= 0 && l < r) {
            if (vowels.indexOf(Character.toLowerCase(ch[l])) == -1) {
                l++;
            } else if (vowels.indexOf(Character.toLowerCase(ch[r])) == -1) {
                r--;
            } else {
                char temp = ch[l];
                ch[l] = ch[r];
                ch[r] = temp;
                l++;
                r--;
            }
        }
        return String.valueOf(ch);
    }
}