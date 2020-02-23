// Diagonal Traverse
// Jan 2020

class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[] answer = new int[m * n];
        int amount_added = 0;
        
        
        // Iterate through the the first row as the head
        int head = 0;
        ArrayList<Integer> diagonal = new ArrayList<Integer>();
        while ( head < n) {
            diagonal.clear();
            int i = 0;
            int j = head;
            
            while (i < m && j >= 0) {
                diagonal.add(matrix[i][j]);
                i++;
                j--;
            }
            
            if (head % 2 == 0) {
                Collections.reverse(diagonal);
            }

            for (int k = 0; k < diagonal.size(); k++) {
                answer[amount_added] = diagonal.get(k);
                amount_added++;
            }
            
            head++;
        }
        
        // Iterate through with last column as the head
        head = 1;
        while (head < m) {
            diagonal.clear();
            int i = head;
            int j = n-1;
            while (i < m && j >= 0) {
                diagonal.add(matrix[i][j]);
                i++;
                j--;
            }
            System.out.println(diagonal);
            if (((head + n) % 2) == 1) {
                Collections.reverse(diagonal);
                System.out.println(diagonal);
            }
            for (int k = 0; k < diagonal.size(); k++) {
                answer[amount_added] = diagonal.get(k);
                amount_added++;
            }
            
            head++;
        }
        
        return answer;
    }
}