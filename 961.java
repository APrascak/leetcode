// N-Repeated Element in Size 2N Array
// 27 May 2020

// O(n) time, O(n) space
class Solution {
    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int num : A) {
            if (set.contains(num))
                return num;
            set.add(num);
        }
        return -1;
    }
}