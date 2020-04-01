// Simplify Path
// 31 March 2020

class Solution {
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        for (int i = 0; i < path.length(); ) {
            char x = path.charAt(i);
            if (x == '/') {
                String curr = "/";
                i++;
                if (i==path.length()) break;
                while (i != path.length() && path.charAt(i) != '/') {
                    curr += path.charAt(i);
                    i++;
                }
                if (curr.equals("/")) {
                    continue;
                } else if (curr.equals("/.")) {
                    continue;
                } else if (curr.equals("/..")) {
                    if (!s.empty()) {
                        s.pop();
                    }
                } else {
                    s.push(curr);
                }
            } else {
                i++;
            }
        }
        String ans = "";
        while (!s.empty()) {
            ans = s.pop() + ans;
        }
        
        if (ans.equals("")) return "/";
        return ans;
    }
}