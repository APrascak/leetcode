// Number Complement
// 4 May 2020

class Solution {
    public int findComplement(int num) {
        if (num == 0) return 1;
        int solution = 0, i = 0;
        while (num != 0) {
            if (num % 2 == 0)
                solution += (int) Math.pow(2, i);
            i++;
            num >>= 1;
        }
        return solution;
        
    }
}