// Find Numbers with Even Number of Digits
// 15 April 2020

class Solution {
    public int findNumbers(int[] nums) {
        int total = 0;
        for (int num : nums) {
            if (hasEvenNumberDigits(num)) total++;
        }
        return total;
    }
    
    public boolean hasEvenNumberDigits(int num) {
        int count = 0;
        while (num > 0) {
            num = num / 10;
            count++;
        }
        return (count % 2) == 0;
    }
}