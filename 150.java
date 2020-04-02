// Evaluate Reverse Polish Notation
// 1 April 2020

class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> set = new HashSet<String>();
        Stack<String> s = new Stack<>();
        set.add("+");
        set.add("/");
        set.add("-");
        set.add("*");
        
        int n = tokens.length;
        if (n==1) { return Integer.parseInt(tokens[0]); }
        
        for (int i = n-1; i >= 0; i--) {
            if (set.contains(tokens[i])) {
                s.add(tokens[i]);
            } else {
                if (!set.contains(s.peek())) {
                    String b = s.pop();
                    String op = s.pop();
                    String ans = eval(tokens[i],op,b);
                    while (!s.isEmpty() && !set.contains(s.peek())) {
                        if (s.size()==1) return Integer.parseInt(s.pop());
                        b = s.pop();
                        op = s.pop();
                        ans = eval(ans,op,b);
                    }
                    s.add(ans);
                } else {
                    s.add(tokens[i]);
                }
            }
        }
        
        return Integer.parseInt(s.pop());
    }
    
    public String eval(String a, String op, String b) {
        if (op.equals("+")) {
            return Integer.toString(Integer.parseInt(a) + Integer.parseInt(b));
        }
        if (op.equals("-")) {
            return Integer.toString(Integer.parseInt(a) - Integer.parseInt(b));
        }
        if (op.equals("/")) {
            return Integer.toString(Integer.parseInt(a) / Integer.parseInt(b));
        }
        if (op.equals("*")) {
            return Integer.toString(Integer.parseInt(a) * Integer.parseInt(b));
        }
        return "";
    }
}