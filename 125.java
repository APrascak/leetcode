// Valid Palindrome
// 6 May 2020

class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (!(Character.isDigit(s.charAt(l)) || Character.isAlphabetic(s.charAt(l)))) {
                l++;
                if (l == s.length()) return true;
            }
            while (!(Character.isDigit(s.charAt(r)) || Character.isAlphabetic(s.charAt(r)))) {
                r--;
                if (r == -1) return true;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r)))
                return false;
            l++;
            r--;
        }
        return true;
    }
}