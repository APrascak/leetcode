// The k-th Lexicographical String of All Happy Strings of Length n
// 22 May 2020

// O(3^n) time and O(3^n) space
class Solution {
    List<String> solution;
    Set<Character> set;
    public String getHappyString(int n, int k) {
        solution = new ArrayList<>();
        set = new HashSet<>();
        set.add('a');
        set.add('b');
        set.add('c');
        backtrack("",'0',n);
        if (k > solution.size()) {
            return "";
        }
        return solution.get(k-1);
    }
    
    private void backtrack(String curr, char letter, int n) {
        if (curr.length() == n) {
            solution.add(new String(curr));
            return;
        }
        for (Character ch : set) {
            if (ch != letter) {
                backtrack(curr+ch, ch, n);
            }
        }
    }
}
