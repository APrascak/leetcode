// Add Strings
// 29 April 2020

class Solution {
    public String addStrings(String num1, String num2) {
        while (num1.length() < num2.length()) {
            num1 = "0" + num1;
        }
        while (num2.length() < num1.length()) {
            num2 = "0" + num2;
        }
        char[] one = num1.toCharArray();
        char[] two = num2.toCharArray();
        int[] sum = helper(one, two);
        String ans = "";
        if (sum[0] >= 10) {
            ans += "1";
            sum[0] -= 10;
        }
        for (int x : sum) {
            ans += Integer.toString(x);
        }
        return ans;
    }
    
    private int[] helper(char[] num1, char[] num2) {
        int[] ans = new int[num1.length];
        int carry = 0;
        for (int i = num1.length - 1; i >= 0; i--) {
            int one = num1[i] - '0';
            int two = num2[i] - '0';
            int digit = one + two + carry;
            carry = 0;
            if (digit >= 10) {
                digit = digit % 10;
                carry = 1;
            }
            ans[i] = digit;
        }
        if (carry == 1) ans[0] += 10;
        return ans;
    }

}