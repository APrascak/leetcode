// Palindrome Number
// 4 May 2020

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        int ref = x;
        int y = 0;
        while (ref != 0) {
            y = y * 10 + (ref % 10);
            ref /= 10;
        }
        return y == x;
    }
}