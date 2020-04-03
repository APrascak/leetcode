// Next Greater Element I
// 3 April 2020

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums2.length; i++) {
            if (!s.isEmpty()) {
                Integer val = s.peek();
                while (nums2[i] > val) {
                    map.put(s.pop(), nums2[i]);
                    if (s.isEmpty()) break;
                    val = s.peek();
                }
            }
            s.push(nums2[i]);
        }
        
        while (!s.isEmpty()) {
            map.put(s.pop(), -1);
        }
 
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }
        
        return nums1;
    }
}