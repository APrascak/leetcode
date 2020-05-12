// Power of Four
// 12 May 2020

class Solution {
    public boolean isPowerOfFour(int num) {
        if (num == 0 || num == Integer.MAX_VALUE) return false;
        int val = 0, i = 0;
        while (val < num) {
            val = (int) Math.pow(4,i);
            System.out.println(val);
            i++;
        }
        return (val == num);
    }
}