// Check If It Is a Straight Line
// 8 May 2020

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        double slope = ((double) coordinates[1][1] - (double) coordinates[0][1]) / ((double) coordinates[1][0] - (double) coordinates[0][0]);
        for (int i = 1; i < coordinates.length; i++) {
            double rise = (double) coordinates[i][1] - (double) coordinates[i-1][1];
            double run = (double) coordinates[i][0] - (double) coordinates[i-1][0];
            if (slope != (double) (rise / run) )
                return false;
        }
        return true;
    }
}