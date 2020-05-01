// N-Queens II
// 30 April 2020

class Solution {
    int[][] danger;
    int count;
    
    public int totalNQueens(int n) {
        danger = new int[n][n];
        count = 0;
        helper(n, 0);
        return count;
    }
    
    private void helper(int n, int row) {
        if (row == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!dangerousSpot(row, i)) {
                placeQueen(row, i, n);
                helper(n, row+1);
                removeQueen(row, i, n);
            }
        }
        
    }
    
    private boolean dangerousSpot(int row, int col) {
        return danger[row][col] >= 1;
    }
    
    private void placeQueen(int row, int col, int n) {
        Set<String> counted = new HashSet<>();
        for (int i = 0; i < n; i++) {
            danger[row][i]++;
            danger[i][col]++;
            counted.add(row+","+i);
            counted.add(i+","+col);
        }
        int x = row;
        int y = col;
        while (x < n && y < n) {
            if (!counted.contains(x+","+y)) {
                danger[x][y]++;
                counted.add(x+","+y);
            }
            x++;
            y++;
        }
        x = row;
        y = col;
        while (x >= 0 && y >= 0) {
            if (!counted.contains(x+","+y)) {
                danger[x][y]++;
                counted.add(x+","+y);
            }
            x--;
            y--;
        }
        x = row;
        y = col;
        while (x < n && y >= 0) {
            if (!counted.contains(x+","+y)) {
                danger[x][y]++;
                counted.add(x+","+y);
            }
            x++;
            y--;
        }
        x = row;
        y = col;
        while (x >= 0 && y < n) {
            if (!counted.contains(x+","+y)) {
                danger[x][y]++;
                counted.add(x+","+y);
            }
            x--;
            y++;
        }
    }
    
    private void removeQueen(int row, int col, int n) {
        Set<String> counted = new HashSet<>();
        for (int i = 0; i < n; i++) {
            danger[row][i]--;
            danger[i][col]--;
            counted.add(row+","+i);
            counted.add(i+","+col);
        }
        int x = row;
        int y = col;
        while (x < n && y < n) {
            if (!counted.contains(x+","+y)) {
                danger[x][y]--;
                counted.add(x+","+y);
            }
            x++;
            y++;
        }
        x = row;
        y = col;
        while (x >= 0 && y >= 0) {
            if (!counted.contains(x+","+y)) {
                danger[x][y]--;
                counted.add(x+","+y);
            }
            x--;
            y--;
        }
        x = row;
        y = col;
        while (x < n && y >= 0) {
            if (!counted.contains(x+","+y)) {
                danger[x][y]--;
                counted.add(x+","+y);
            }
            x++;
            y--;
        }
        x = row;
        y = col;
        while (x >= 0 && y < n) {
            if (!counted.contains(x+","+y)) {
                danger[x][y]--;
                counted.add(x+","+y);
            }
            x--;
            y++;
        }
    }
    
}


/*

0 0 0 0
0 0 0 0
0 0 0 0
0 0 0 0

*/