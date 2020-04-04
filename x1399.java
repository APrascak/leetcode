// Count Largest Group
// 4 April 2020

class Solution {
    public int countLargestGroup(int n) {
        // Map to store: sum -> frequency
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        
        // iterate through values up to n
        for (int i = 1; i <= n; i++) {
            // calculate sum of digits
            int val = 0, x = i;
            while (x > 0) {
                val += x % 10;
                x = x / 10;
            }
            // update map and max frequency
            map.put(val, map.getOrDefault(val, 0) + 1);
            max = Math.max(max, map.get(val));
        }
        
        // count all values that have frequency
        int count = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) == max) count++;
        }
        
        return count;
    }
}