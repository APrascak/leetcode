// Diagonal Traverse II
// 23 May 2020

// O(n) time and space
class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<List<Integer>> list = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < nums.size(); i++) {
            max = Math.max(max, i + nums.get(i).size());
        }
        System.out.println(max);
        for (int i = 0; i < max; i++) {
            list.add(new ArrayList<>());
        }
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                list.get(i+j).add(nums.get(i).get(j));
                count++;
            }
        }
        for (List<Integer> x : list)
            Collections.reverse(x);
        int[] ans = new int[count];
        int pos = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                ans[pos] = list.get(i).get(j);
                pos++;
            }
        }
        return ans;
    }
}