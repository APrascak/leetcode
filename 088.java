// Merge Sorted Array
// 15 April 2020

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        int a = m-1, b = n-1;
        int pos = nums1.length - 1;
        while (pos >= 0) {
            if (a == -1) {
                nums1[pos] = nums2[b];
                pos--;
                b--;
                continue;
            }
            if (b == -1) {
                nums1[pos] = nums1[a];
                pos--;
                a--;
                continue;
            }
            int aa = nums1[a];
            int bb = nums2[b];
            nums1[pos] = Math.max(aa, bb);
            if (aa == nums1[pos]) a--;
            else b--;
            pos--;
        }
    }
}