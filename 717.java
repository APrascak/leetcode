// 1-bit and 2-bit Characters
// 23 March 2020

// (April 5 2020) solution using stack
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        Stack<Integer> s = new Stack<>();
        for (int i = n-1; i >= 0; i--) {
            s.push(bits[i]);
        }
        
        while (!s.isEmpty()) {
            if (s.size() == 1) return true;
            if (s.pop() == 1) {
                s.pop();
            }
        }
        return false;
    }
}

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

