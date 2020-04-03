// Rotting Oranges
// 3 April 2020

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Integer[]> s = new LinkedList();
        int max = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    s.offer(new Integer[]{i,j});
                    while (!s.isEmpty()) {
                        Integer[] coords = s.poll();
                        Integer x = coords[0];
                        Integer y = coords[1];
                        if (x-1 >= 0 && ( grid[x-1][y] == 1 || grid[x-1][y] > grid[x][y]) ) {
                            grid[x-1][y] = grid[x][y] + 1;
                            s.offer(new Integer[]{x-1, y});
                        }
                        if (x+1 < grid.length && ( grid[x+1][y] == 1 || grid[x+1][y] > grid[x][y]) ) {
                            grid[x+1][y] = grid[x][y] + 1;
                            s.offer(new Integer[]{x+1, y});
                        }
                        if (y-1 >= 0 && ( grid[x][y-1] == 1 || grid[x][y-1] > grid[x][y]) ) {
                            grid[x][y-1] = grid[x][y] + 1;
                            s.offer(new Integer[]{x, y-1});
                        }
                        if (y+1 < grid[x].length && ( grid[x][y+1] == 1 || grid[x][y+1] > grid[x][y]) ) {
                            grid[x][y+1] = grid[x][y] + 1;
                            s.offer(new Integer[]{x, y+1});
                        }
                    }
                }
            }
        }
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                max = Math.max(grid[i][j], max);
                if (grid[i][j] == 1) return -1;
            }
        }

        if (max == 0) return 0;
        return max-2;
    }
}