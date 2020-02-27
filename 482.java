// License Key Formatting
// 27 Feb 2020

class Solution {
    public String licenseKeyFormatting(String S, int K) {
        int dashCount = 0;
        int n = S.length();
        StringBuilder licenseKey = new StringBuilder();
        
        
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == '-') {
                dashCount++;
            } else {
                licenseKey.append(S.charAt(i));
            }
        }
        
        if (dashCount == n) {
            return "";
        }
        
        int divisible = (n - dashCount) % K;
        StringBuilder solution = new StringBuilder();
        if (divisible == 0) {
            for (int i = 0; i < licenseKey.length(); i++) {
                solution.append(Character.toUpperCase(licenseKey.charAt(i)));
                if (i % K == K-1) {
                    solution.append("-");
                }
            }
        } else {
            for (int i = 0; i < divisible; i++) {
                solution.append(Character.toUpperCase(licenseKey.charAt(i)));
            }
            solution.append("-");
            for (int i = divisible; i < licenseKey.length(); i++) {
                solution.append(Character.toUpperCase(licenseKey.charAt(i)));
                if ((i-divisible) % K == K-1) {
                    solution.append("-");
                }
            }
        }
        
        if (solution.charAt(solution.length()-1) == '-') {
            return solution.substring(0,solution.length()-1).toString();
        }
        return solution.toString();
    }
}