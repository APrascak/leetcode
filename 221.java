// Maximal Square
// 27 April 2020

// Brute-force Solution O((mn)^2) complexity
// Worst case is that we have to check the entire array for every index
class Solution {
    public int maximalSquare(char[][] matrix) {
        Queue<Integer[]> queue = new LinkedList();
        int area = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    area = Math.max(area, helper(matrix, i, j));       
                }
            }
        }
        return area;
    }
    
    private int helper(char[][] matrix, int x, int y) {
        int size = 1;
        int area = 1;
        boolean increaseSize;
        while (valid(matrix, x+size, y+size)) {
            increaseSize = true;
            for (int i = 0; i <= size; i++) {
                if (matrix[x+i][y+size] != '1' || matrix[x+size][y+i] != '1') {
                    increaseSize = false;
                }
            }
            if (increaseSize) {
                size++;
                area = Math.max(area, (int) Math.pow(size,2));
            } else {
                return area;
            }
        }
        return area;
    }
    
    private boolean valid(char[][] matrix, int x, int y) {
        if (x >= matrix.length || y >= matrix[x].length) return false;
        return true;
    }
}

// DP solution with O(mn) complexity
class Solution {
    char[][] matrix;
    int[][] dp;
    
    public int maximalSquare(char[][] matrix) {
        int area = 0;
        this.matrix = matrix;
        dp = initializeDpArray();
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = dpCalculation(i,j);
                area  = Math.max(area, dp[i][j]);
            }
        }
                
        return (int) Math.pow(area,2);
    }
    
    private int[][] initializeDpArray() {
        if (matrix.length == 0) return new int[0][0];
        return new int[matrix.length + 1][matrix[0].length + 1];
    }
    
    private int dpCalculation(int i, int j) {
        if (matrix[i-1][j-1] == '0') return 0;
        return Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
    }
    
    private void printDpMatrix() {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}