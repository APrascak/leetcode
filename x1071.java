// Greatest Common Divisor of Strings
// 6 May 2020

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String one = findDuplicate(str1);
        String two = findDuplicate(str2);
        String ans = "";
        if (one.equals(two)) {
            String ref = new String(one);
            ans = ref;
            while (ref.length() <= str1.length() && ref.length() <= str2.length()) {
                if (valid(ref,str1) && valid(ref,str2)) {
                    ans = ref;
                    ref += one;
                } else {
                    ref += one;
                }
            }
            return ans;
        }
        return "";
    }
    
    private String findDuplicate(String str) {
        for (int i = 1; i <= str.length() / 2; i++) {
            if (valid(str.substring(0,i), str))
                return str.substring(0,i);
        }
        return str;
    }
    
    private boolean valid(String a, String b) {
        String ref = new String(a);
        while (a.length() <= b.length()) {
            if (a.equals(b)) return true;
            a += ref;
        }
        return false;
    }
}