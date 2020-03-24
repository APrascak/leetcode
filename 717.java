// 1-bit and 2-bit Characters
// 23 March 2020

class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        if (n==1) { return true; }
        if (n==2) { return (bits[0] == 0); }
        for (int i = 0; i < n; ) {
            if (bits[i] == 0) {
                i++;
            } else {
                i+=2;
            }
            if (i == n-1) {
                return true;
            }
            if (i == n) {
                return false;
            }
        }
        return true;
    }
}