// Pascal's Triangle
// 6 Feb 2020

class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        // Establish first 2 rows of triangle
        List<List<Integer>> solution = new ArrayList<List<Integer>>();
        List<Integer> first = new ArrayList<Integer>();
        first.add(1);
        List<Integer> second = new ArrayList<Integer>();
        second.add(1);
        second.add(1);
        if (numRows == 0) {
            return solution;
        }
        solution.add(first);
        if (numRows == 1) {
            return solution;
        }
        solution.add(second);
        if (numRows == 2) {
            return solution;
        }
                
        for (int i = 2; i < numRows; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(solution.get(i-1).get(j) + solution.get(i-1).get(j-1));
            }
            row.add(1);
            solution.add(row);
        }
        return solution;
    }
}