// Permutations
// 5 April 2020

// Backtracking solution
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> solution = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack(solution, new ArrayList<>(), nums);
        return solution;
    }
    
    public void backtrack(List<List<Integer>> list, List<Integer> curr, int[] nums) {
        if (curr.size() == nums.length) {
            list.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (curr.contains(nums[i])) continue;
            curr.add(nums[i]);
            backtrack(list, curr, nums);
            curr.remove(curr.size()-1);
        }
    }
}

// Brute force solution using queue
class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int n = nums.length;
        Queue<List<Integer>> queue = new LinkedList();
        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(nums[i]);
            queue.add(temp);
        }
        while (!queue.isEmpty()) {
            List<Integer> ref = queue.poll();
            if (ref.size() == n) {
                Set<Integer> s = new HashSet<>();
                boolean unique = true;
                for (int i = 0; i < n; i++) {
                    if (s.contains(ref.get(i))) {
                        unique = false;
                    } else {
                        s.add(ref.get(i));
                    }
                }
                if (unique) {
                    ans.add(ref);
                }
            } else {
                for (int i = 0; i < n; i++) {
                    List<Integer> x = new ArrayList<>(ref);
                    x.add(nums[i]);
                    queue.offer(x);
                }
            }
        }
        
        return ans;
    }
}