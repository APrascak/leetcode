// Generate Parentheses
// 4 May 2020

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> solution = new ArrayList<>();
        backtrack(solution, "", 0, 0, n);
        return solution;
    }
    
    public void backtrack(List<String> solution, String curr, int open, int close, int n) {
        if (curr.length() == n * 2) {
            solution.add(curr);
            return;
        }
        if (open < n)
            backtrack(solution, curr+"(", open+1, close, n);
        if (close < open)
            backtrack(solution, curr+")", open, close+1, n);
    }
}