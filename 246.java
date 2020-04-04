// Strobogrammatic Number
// 4 April 2020

class Solution {
    public boolean isStrobogrammatic(String num) {
        int n = num.length();
        String x = "";
        Set<Character> s = new HashSet<>();
        s.add('2');
        s.add('3');
        s.add('4');
        s.add('5');
        s.add('7');
        
        for (int i = n-1; i >= 0; i--) {
            if (s.contains(num.charAt(i))) return false;
            if (num.charAt(i) == '6') {
                x+='9';
            } else if (num.charAt(i) == '9') {
                x+='6';
            } else {
                x += num.charAt(i);
            }
        }
        
        return x.equals(num);
    }
}