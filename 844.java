// Backspace String Compare
// 9 April 2020

class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s = new Stack<>();
        for (Character ch : S.toCharArray()) {
            if (ch == '#') {
                if (!s.isEmpty()) {
                    s.pop();
                }
            } else {
                s.push(ch);
            }
        }
        
        String x = "";
        while (!s.isEmpty()) {
            x = s.pop() + x;
        }
        
        for (Character ch : T.toCharArray()) {
            if (ch == '#') {
                if (!s.isEmpty()) {
                    s.pop();
                }
            } else {
                s.push(ch);
            }
        }
        
        String y = "";
        while (!s.isEmpty()) {
            y = s.pop() + y;
        }
                
        return (x.equals(y));
    }
}