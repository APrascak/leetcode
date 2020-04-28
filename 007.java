// Reverse Integer
// 28 April 2020

class Solution {
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int digit = x % 10;
            ans *= 10;
            ans += x % 10;
            if (ans % 10 != digit) return 0;
            x /= 10;
        }
        return ans;
    }
}