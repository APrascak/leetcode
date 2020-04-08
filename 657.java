// Robot Return to Origin
// 7 April 2020

class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (char ch : moves.toCharArray()) {
            if (ch == 'U') y++;
            if (ch == 'D') y--;
            if (ch == 'L') x--;
            if (ch == 'R') x++;
        }
        return (x == 0 && y == 0);
    }
}