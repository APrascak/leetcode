// Intersection of Two Arrays
// 27 March 2020

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> found = new HashSet<Integer>();
        Set<Integer> intersection = new HashSet<Integer>();
        for (int i : nums1) {
            found.add(i);
        }
        for (int j : nums2) {
            if (found.contains(j)) {
                intersection.add(j);
                found.remove(j);
            }
        }
        int[] solution = new int[intersection.size()];
        int index = 0;
        for (int k : intersection) {
            solution[index] = k;
            index++;
        }
        return solution;
    }
}