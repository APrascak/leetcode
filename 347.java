// Top K Frequent Elements
// 30 March 2020

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int value : nums) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        // Utilizes bucket sort with frequencies as indexes
        List<Integer>[] buckets = new List[nums.length+1];
        for (int key : map.keySet()) {
            if (buckets[map.get(key)] == null) {
                buckets[map.get(key)] = new ArrayList();
                buckets[map.get(key)].add(key);
            } else {
                buckets[map.get(key)].add(key);
            }
        }
        
        int i = buckets.length-1;
        List<Integer> ans = new ArrayList<Integer>();
        while (i > -1 && ans.size() < k) {
            if (buckets[i] != null) {
                ans.addAll(buckets[i]);
            }
            i--;
        }
        
        return ans;
    }
}