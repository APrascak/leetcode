// Max Difference You Can Get From Changing an Integer
// 3 May 2020

class Solution {
    int num;
    
    public int maxDiff(int num) {
        this.num = num;
        int ref = num;
        int size = 0;
        while (ref != 0) {
            ref = ref / 10;
            size++;
        }
        ref = num;
        int[] values = new int[size];
        for (int i = size-1; i >= 0; i--) {
            values[i] = ref % 10;
            ref /= 10;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int val : values) {
            max = Math.max(max, findMax(val));
            min = Math.min(min, findMin(val));
        }
        return max - min;
    }
    
    private int findMax(int x) {
        int ref = num, high = 0, i = 0;
        while (ref != 0) {
            int a = ref % 10;
            if (a == x) {
                a = 9;
            }
            high = high + a * (int) Math.pow(10, i);
            i++;
            ref /= 10;
        }
        return high;
    }
    
    private int findMin(int x) {
        int ref = num, low = 0, i = 0;
        boolean flagged = false;
        while (ref != 0) {
            int a = ref % 10;
            if (a == x) {
                a = 0;
            }
            low = low + a * (int) Math.pow(10, i);
            i++;
            ref /= 10;
            if (a == 0 && ref == 0) flagged = true;
        }
        if (low == 0 || flagged) {
            ref = num;
            low = 0;
            i = 0;
            while (ref != 0) {
                int a = ref % 10;
                if (a == x) {
                    a = 1;
                }
                low = low + a * (int) Math.pow(10, i);
                i++;
                ref /= 10;
            }
        }
        return low;
    }
}