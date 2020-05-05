// Find All Numbers Disappeared in an Array
// 4 May 2020

// O(n) time with no extra space
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int x : nums) {
            int index = Math.abs(x) - 1;
            if (nums[index] > 0)
                nums[index] *= -1;
        }
        List<Integer> solution = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            if (nums[i] > 0)
                solution.add(i+1);
        return solution;
    }
}