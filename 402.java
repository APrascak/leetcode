// Remove K Digits
// 13 May 2020

// O(n) time and space
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (Character dig : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && dig < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(dig);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        String answer = "";
        while (!stack.isEmpty()) {
            answer = stack.pop() + answer;
        }
        if (answer.equals(""))
            return "0";
        while (answer.charAt(0) == '0') {
            answer = answer.substring(1);
            if (answer.equals(""))
                return "0";
        }
        return answer;
    }
}