// Happy Number
// 27 March 2020

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<Integer>();
        int val = n;
        int sum = 0;
        while (true) {
            while (val > 0) {
                sum += Math.pow(val % 10, 2);
                val = val / 10;
            }
            if (sum == 1) {
                return true;
            }
            if (seen.contains(sum)) {
                break;
            }
            seen.add(sum);
            val = sum;
            sum = 0;
        }
        return false;
    }
}