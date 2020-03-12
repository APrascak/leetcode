// Fizz Buzz
// 12 March 2020

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> solution = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0 && i % 3 == 0) {
                solution.add("FizzBuzz");
            } else if (i % 5 == 0) {
                solution.add("Buzz");
            } else if (i % 3 == 0) {
                solution.add("Fizz");
            } else {
                solution.add(Integer.toString(i));
            }
        }
        return solution;
    }
}