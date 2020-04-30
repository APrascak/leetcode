// Sort an Array
// 30 April 2020

class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length <= 1) return nums;
        int pivot = nums.length / 2;
        int[] left = sortArray(Arrays.copyOfRange(nums,0,pivot));
        int[] right = sortArray(Arrays.copyOfRange(nums,pivot, nums.length));
        return merge(left, right);
    }
    
    private int[] merge(int[] a, int[] b) {
        int[] answer = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                answer[k] = a[i];
                i++;
            } else {
                answer[k] = b[j];
                j++;
            }
            k++;
        }
        while (i < a.length) {
            answer[k] = a[i];
            i++;
            k++;
        }
        while (j < b.length) {
            answer[k] = b[j];
            j++;
            k++;
        }
        return answer;
    }
}