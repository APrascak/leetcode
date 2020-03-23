// Long Pressed Name
// 23 March 2020

class Solution {
    public boolean isLongPressedName(String name, String typed) {
        
        // Edge cases
        if (name.equals(typed)) { return true; }
        if (name.charAt(0) != typed.charAt(0)) { return false; }
        
        int n = name.length();
        int m = typed.length();
        int i = 0;
        int j = 0;
        
        // Two pointers moving through each string
        while (i != n && j != m) {
            // System.out.println(name.charAt(i) + " : " + typed.charAt(j));
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (name.charAt(i-1) == typed.charAt(j)) {
                j++;
            } else {
                return false;
            }
        }
        
        if (i != n) { return false; }
        
        return true;
    }
}