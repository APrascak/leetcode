// How Many Apples Can You Put into the Basket
// 5 April 2020

class Solution {
    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int weight = 0, i = 0;
        while (weight < 5000 && i < arr.length) {
            weight += arr[i];
            if (weight > 5000) return i;
            i++;
        }
        return i;
    }
}