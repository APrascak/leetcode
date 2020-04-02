// Reverse String
// 2 April 2020

class Solution {
    public void reverseString(char[] s) {
        reverse(0,s);
    }
    
    public static void reverse(int index, char[] x) {
        if (index >= x.length / 2) return;
        char temp = x[index];
        x[index] = x[x.length-1-index];
        x[x.length-1-index] = temp;
        reverse(index+1, x);
    }
}