// Power of Two
// 4 May 2020

class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        while (n != 1) {
            if (n % 2 != 0) return false;
            n /= 2;
        }
        return true;
    }
}