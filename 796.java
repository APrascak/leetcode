// Rotate String
// 27 Feb 2020

class Solution {
    public boolean rotateString(String A, String B) {
        if (A.equals("") && B.equals("")) { return true; } 
        
        for (int i = 0; i < A.length(); i++) {
            A = shift(A);
            if (B.equals(A) == true) {
                return true;
            }
        }
        return false;
    }
    
    public String shift(String x) {
        StringBuilder temp = new StringBuilder();
        for(int i = 1; i < x.length(); i++) {
            temp.append(x.charAt(i));
        }
        temp.append(x.charAt(0));
        return temp.toString();
    } 
}