// Spiral Matrix
// 27 March 2020

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> solution = new ArrayList<Integer>();
        int m = matrix.length;
        if (m == 0) { return solution; }
        int n = matrix[0].length;
        int topRow = 0, botRow = m-1, leftCol = 0, rightCol = n-1;
        int x = 0, y = 0;
        
        while (topRow <= botRow && leftCol <= rightCol) {
            // top iteration
            while (y < rightCol) {
                solution.add(matrix[x][y]);
                y++;
            }
            topRow++;
            
            if (m == 1) { break; }
        
            
            // down right side
            while (x < botRow) {
                solution.add(matrix[x][y]);
                x++;
            } 
            rightCol--;
            
             if (!(topRow <= botRow && leftCol <= rightCol)) {
                break;
            }
        
            // across bottom
            while (y > leftCol) {
                solution.add(matrix[x][y]);
                y--;
            }
            botRow--;

            
            // up left side
            while (x > topRow) {
                solution.add(matrix[x][y]);
                x--;
            }
            leftCol++;
        }
        if (solution.size() < m*n) {
            solution.add(matrix[x][y]);   
        }
        
        return solution;
        
    }
    public void print(List<Integer> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            System.out.print(matrix.get(i) + " ");
        }
        System.out.println();
    }
    
}