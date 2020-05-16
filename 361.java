// Bomb Enemy
// 16 May 2020

class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0')
                    ans = Math.max(ans, determineCount(grid,i,j));
            }
        }
        return ans;
    }
    
    private int determineCount(char[][] grid, int i , int j) {
        int x = i, y = j;
        int count = 0;
        while (x >= 0 && grid[x][y] != 'W') {
            if (grid[x][y] == 'E')
                count++;
            x--;
        }
        x = i;
        while (x < grid.length && grid[x][y] != 'W') {
            if (grid[x][y] == 'E')
                count++;
            x++;
        }
        x = i;
        while (y >= 0 && grid[x][y] != 'W') {
            if (grid[x][y] == 'E')
                count++;
            y--;
        }
        y = j;
        while (y < grid[0].length && grid[x][y] != 'W') {
            if (grid[x][y] == 'E')
                count++;
            y++;
        }
        return count;
    }
}