// 3Sum
// 2 April 2020

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length-2; i++) {
            if (i==0 || (i>0 && nums[i] != nums[i-1])) {
                int lo = i+1;
                int hi = nums.length-1;
                int comp = 0-nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == comp) {
                        List<Integer> x = new ArrayList<>();
                        x.add(nums[i]);
                        x.add(nums[lo]);
                        x.add(nums[hi]);
                        ans.add(x);
                        lo++;
                        while (lo < hi && nums[lo]==nums[lo-1]) lo++;
                        hi--;
                        while (lo < hi && nums[hi]==nums[hi+1]) hi--;
                    } else if (nums[lo] + nums[hi] < comp) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return ans;
    }
}