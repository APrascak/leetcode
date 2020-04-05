// Number of Steps to Reduce a Number in Binary Representation to One
// 5 April 2020

class Solution {
    public int numSteps(String s) {
        int steps = 0;
        while (!s.equals("1")) {
            if (s.charAt(s.length()-1) == '1') {
                s = inc(s);
            } else {
                s = div(s);
            }
            steps++;
        }
        return steps;
        
    }
    
    public String inc(String s) {
        int n = s.length();
        String ans = "";
        boolean carry = true;
        for (int i = n-1; i >= 0; i--) {
            if (s.charAt(i) == '1' && carry) {
                ans = '0' + ans;
            } else if (s.charAt(i) == '0' && carry) {
                carry = false;
                ans = '1' + ans;
            } else {
                ans = s.charAt(i) + ans;
            }
        }
        if (carry) return "1" + ans;
        return ans;
    }
    
    public String div(String s) {
        return s.substring(0,s.length()-1);
    }
}