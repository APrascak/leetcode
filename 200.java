// Number of Islands
// 31 March 2020

class Solution {
    public int numIslands(char[][] grid) {
        Queue<Integer[]> queue = new LinkedList();
        Set<String> seen = new HashSet<String>();
        int count = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                String pos = Integer.toString(i) + "," + Integer.toString(j);
                if ((grid[i][j] == '1') && (!seen.contains(pos)) ) {
                    count++;
                    // System.out.println(i+":"+j);
                    // System.out.println("yeet");
                    queue.offer(new Integer[]{i, j});
                    while (!queue.isEmpty()) {
                        Integer[] coords = queue.poll();
                        int x = coords[0];
                        int y = coords[1];
                        if (x-1 >= 0) {
                            if (grid[x-1][y] == '1' && !seen.contains(Integer.toString(x-1) + "," + Integer.toString(y))) {
                                seen.add(Integer.toString(x-1) + "," + Integer.toString(y));
                                queue.offer(new Integer[]{x-1, y});
                            }
                        }
                        if (x+1 < grid.length) {
                            if (grid[x+1][y] == '1' && !seen.contains(Integer.toString(x+1) + "," + Integer.toString(y))) {
                                seen.add(Integer.toString(x+1) + "," + Integer.toString(y));
                                queue.offer(new Integer[]{x+1, y});
                            }
                        }
                        if (y-1 >= 0) {
                            if (grid[x][y-1] == '1' && !seen.contains(Integer.toString(x) + "," + Integer.toString(y-1))) {
                                seen.add(Integer.toString(x) + "," + Integer.toString(y-1));
                                queue.offer(new Integer[]{x, y-1});
                            }
                        }
                        if (y+1 < grid[i].length) {
                            if (grid[x][y+1] == '1' && !seen.contains(Integer.toString(x) + "," + Integer.toString(y+1))) {
                                seen.add(Integer.toString(x) + "," + Integer.toString(y+1));
                                queue.offer(new Integer[]{x, y+1});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}