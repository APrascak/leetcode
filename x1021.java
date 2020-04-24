// Remove Outermost Parentheses
// 24 April 2020

class Solution {
    public String removeOuterParentheses(String S) {
        Deque<Character> stack = new LinkedList();
        String answer = "";
        for (Character ch : S.toCharArray()) {
            System.out.println(answer);
            if (ch == '(') {
                if (stack.isEmpty()) {
                    stack.offer(ch);
                } else {
                    stack.offer(ch);
                    answer += "(";
                }
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    answer += ")";
                }
            }
        }
        return answer;
    }
}