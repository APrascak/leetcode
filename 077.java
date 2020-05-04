// Combinations
// 4 May 2020

class Solution {
    List<List<Integer>> combinations;
    int n;
    int k;
    
    public List<List<Integer>> combine(int n, int k) {
        combinations = new ArrayList<List<Integer>>();
        this.n = n;
        this.k = k;
        helper(1, new ArrayList<>());
        return combinations;
    }
    
    private void helper(int curr, List<Integer> combination) {
        if (combination.size() == k) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        for (int i = curr; i <= n; i++) {
            combination.add(i);
            helper(i+1, combination);
            combination.remove(combination.size()-1);
        }
    }

}