// Reverse Words in a String
// 19 Feb 2020

class Solution {
    public String reverseWords(String s) {
        String[] solution = s.trim().split("\\s+");
        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution[i]);
        }
        int i = 0;
        int j = solution.length-1;
        while (i < j) {
            String temp = new String(solution[i]);
            solution[i] = solution[j];
            solution[j] = temp;
            i++;
            j--;
        }
        
        String answer = new String();
        for (int k = 0; k < solution.length; k++) {
            answer += solution[k] + " ";
        }
        
        return answer.substring(0,answer.length()-1);
    }
}