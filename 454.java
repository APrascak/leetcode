// 4Sum II
// 29 March 2020

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) +1);
            }
        }
        
        int ans = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int complement = 0 - (C[i] + D[j]);
                ans += map.getOrDefault(complement,0);
            }
        }
        return ans;
    }
}