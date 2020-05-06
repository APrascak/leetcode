// Letter Combinations of a Phone Number
// 5 May 2020

// Back-tracking solution
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.equals("")) return combinations;
        backtrack(combinations, "", digits);
        return combinations;
    }
    
    private void backtrack(List<String> combinations, String curr, String digits) {
        if (curr.length() == digits.length()) {
            combinations.add(curr);
            return;
        }
        char ch = digits.charAt(curr.length());
        if (ch == '2') {
            curr += 'a';
            backtrack(combinations, curr, digits);
            curr = curr.substring(0, curr.length()-1);
            curr += 'b';
            backtrack(combinations, curr, digits);
            curr = curr.substring(0, curr.length()-1);
            curr += 'c';
            backtrack(combinations, curr, digits);
            curr = curr.substring(0, curr.length()-1);
        } else if (ch == '3') {
            curr += 'd';
            backtrack(combinations, curr, digits);
            curr = curr.substring(0, curr.length()-1);
            curr += 'e';
            backtrack(combinations, curr, digits);
            curr = curr.substring(0, curr.length()-1);
            curr += 'f';
            backtrack(combinations, curr, digits);
            curr = curr.substring(0, curr.length()-1);
        } else if (ch == '4') {
            curr += 'g';
            backtrack(combinations, curr, digits);
            curr = curr.substring(0, curr.length()-1);
            curr += 'h';
            backtrack(combinations, curr, digits);
            curr = curr.substring(0, curr.length()-1);
            curr += 'i';
            backtrack(combinations, curr, digits);
            curr = curr.substring(0, curr.length()-1);
        }  else if (ch == '5') {
            curr += 'j';
            backtrack(combinations, curr, digits);
            curr = curr.substring(0, curr.length()-1);
            curr += 'k';
            backtrack(combinations, curr, digits);
            curr = curr.substring(0, curr.length()-1);
            curr += 'l';
            backtrack(combinations, curr, digits);
            curr = curr.substring(0, curr.length()-1);
        } else if (ch == '6') {
            curr += 'm';
            backtrack(combinations, curr, digits);
            curr = curr.substring(0, curr.length()-1);
            curr += 'n';
            backtrack(combinations, curr, digits);
            curr = curr.substring(0, curr.length()-1);
            curr += 'o';
            backtrack(combinations, curr, digits);
            curr = curr.substring(0, curr.length()-1);
        } else if (ch == '7') {
            curr += 'p';
            backtrack(combinations, curr, digits);
            curr = curr.substring(0, curr.length()-1);
            curr += 'q';
            backtrack(combinations, curr, digits);
            curr = curr.substring(0, curr.length()-1);
            curr += 'r';
            backtrack(combinations, curr, digits);
            curr = curr.substring(0, curr.length()-1);
            curr += 's';
            backtrack(combinations, curr, digits);
            curr = curr.substring(0, curr.length()-1);
        } else if (ch == '8') {
            curr += 't';
            backtrack(combinations, curr, digits);
            curr = curr.substring(0, curr.length()-1);
            curr += 'u';
            backtrack(combinations, curr, digits);
            curr = curr.substring(0, curr.length()-1);
            curr += 'v';
            backtrack(combinations, curr, digits);
            curr = curr.substring(0, curr.length()-1);
        } else if (ch == '9') {
            curr += 'w';
            backtrack(combinations, curr, digits);
            curr = curr.substring(0, curr.length()-1);
            curr += 'x';
            backtrack(combinations, curr, digits);
            curr = curr.substring(0, curr.length()-1);
            curr += 'y';
            backtrack(combinations, curr, digits);
            curr = curr.substring(0, curr.length()-1);
            curr += 'z';
            backtrack(combinations, curr, digits);
            curr = curr.substring(0, curr.length()-1);
        }
    }
}