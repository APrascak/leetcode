// Intersection of Three Sorted Arrays
// 3 April 2020

class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> ans  = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i=0; i < arr1.length; i++) {
            map.put(arr1[i], 1);
        }
        
        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey(arr2[i])) {
                map.put(arr2[i], map.get(arr2[i])+1);
            }
        }
        
        for (int i = 0; i < arr3.length; i++) {
            if (map.getOrDefault(arr3[i], 0) == 2) {
                ans.add(arr3[i]);
            }
        }
        
        return ans;
    }
}