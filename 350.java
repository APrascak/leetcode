// Intersection of Two Arrays II
// 28 March 2020

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        
        // Map: value -> count
        for (int i = 0; i <nums1.length; i++) {
            int value = nums1[i];
            if (map.containsKey(value)) {
                map.put(value, map.get(value) + 1);
            } else {
                map.put(value, 1);
            }
        }
        
        // Map: matchingValues -> frequency
        int count = 0;
        for (int i = 0; i < nums2.length; i++) {
            int value = nums2[i];
            if (map.containsKey(value)) {
                if (map2.containsKey(value)) {
                    if (map.get(value) > map2.get(value)) {
                        map2.put(value, map2.get(value) + 1); // increase count for another instances
                        count++;
                    }
                } else {
                    map2.put(value, 1);
                    count++;
                }
            }
        }
        
        // Convert 2nd map to int array
        int[] solution = new int[count];
        int i = 0;
        for (Integer key : map2.keySet()) {
            for (int j = 0; j < map2.get(key); j++) {
                solution[i] = key;
                i++;
            }
        }
        return solution;
        
        
    }
}