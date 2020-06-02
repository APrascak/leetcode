// Break a Palindrome
// 1 June 2020

// O(n) time, O(n) space
// Could also be done with O(1) space without using char array
class Solution {
    public String breakPalindrome(String palindrome) {
        int l = 0, n = palindrome.length()-1;
        char[] word = palindrome.toCharArray();
        while (l < n) {
            if (palindrome.charAt(l) != 'a' && l != n-l) {
                word[l] = 'a';
                return String.valueOf(word);
            } else {
                l++;
            }
        }
        if (n != 0) {
            word[n] = 'b';
            return String.valueOf(word);
        }
        return "";
    }
}