// Minimum Remove to Make Valid Parentheses
// 18 May 2020

class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> open = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch == '(') {
                open.push(i);
                i++;
            } else if (ch == ')') {
                if (open.isEmpty()) {
                    s = s.substring(0,i) + s.substring(i+1);
                } else {
                    i++;
                    open.pop();
                }
            } else {
                i++;
            }
        }
        while (!open.isEmpty()) {
            int pos = open.pop();
            s = s.substring(0,pos) + s.substring(pos+1);
        }
        return s;
    }
}