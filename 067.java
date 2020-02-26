// Add Binary
// 10 Feb 2020

class Solution {
    public String addBinary(String a, String b) {
        int n = a.length();
        int m = b.length();
        
        int min;
        if (n < m) {
            min = n;
        } else {
            min = m;
        }
        
        char[] a_bits = new StringBuilder(new String(a)).reverse().toString().toCharArray();
        char[] b_bits = new StringBuilder(new String(b)).reverse().toString().toCharArray();
        StringBuilder answer = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < min; i++) {
            int sum = Character.getNumericValue(a_bits[i]) + Character.getNumericValue(b_bits[i]) + carry;
            if (sum == 2) {
                answer.append(0);
                carry = 1;
            } else if (sum == 3) {
                answer.append(1);
                carry = 1;
            } else {
                carry = 0;
                answer.append(sum);
            }
        }
        
        if (n > min) {
            for (int i = min; i < n; i++) {
                int sum = Character.getNumericValue(a_bits[i]) + carry;
                if (sum == 2) {
                    answer.append(0);
                    carry = 1;
                } else if (sum == 3) {
                    answer.append(1);
                    carry = 1;
                } else {
                    carry = 0;
                    answer.append(sum);
                }
            }
        }
        
        if (m > min) {
            for (int i = min; i < m; i++) {
                int sum = Character.getNumericValue(b_bits[i]) + carry;
                if (sum == 2) {
                    answer.append(0);
                    carry = 1;
                } else if (sum == 3) {
                    answer.append(1);
                    carry = 1;
                } else {
                    carry = 0;
                    answer.append(sum);
                }
            }
        }
        
        if (carry == 1) {
            answer.append(1);
        }
        
        return answer.reverse().toString();
    }
}