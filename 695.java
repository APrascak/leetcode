// Max Area of Island
// 2 June 2020

// O(n^2) time, O(n^2) space
class Solution {
    int[][] matrix;
    public int maxAreaOfIsland(int[][] grid) {
        matrix = grid;
        printMatrix();
        int max = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                if (grid[i][j] == 1)
                    max = Math.max(max, calcSize(i,j));
        return max;
    }
    
    private int calcSize(int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length || matrix[i][j] == 0)
            return 0;
        matrix[i][j] = 0;
        return 1 + calcSize(i+1, j) + calcSize(i-1, j) + calcSize(i, j+1) + calcSize(i, j-1);
    }
    
    private void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}