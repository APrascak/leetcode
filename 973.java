// K Closest Points to Origin
// 20 March 2020

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int[][] solution = new int[K][2];
        
        // Store distance in x position of point. If original x position was negative then distance is negative.
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] > 0) {
                points[i][0] = (int) Math.pow(points[i][0], 2) + (int) Math.pow(points[i][1], 2);
            } else {
                points[i][0] = ((int) Math.pow(points[i][0], 2) + (int) Math.pow(points[i][1], 2)) * -1 ;
            }
        }
        

        // Sort array by absolute distance from origin        
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(Math.abs(a[0]), Math.abs(b[0]));
            }
        });
        
        // Add k closest points to solution array. Handling for pos. or neg. values.
        for (int i = 0; i < K; i++) {
            int[] temp = points[i];
            if (points[i][0] > 0) {
                temp[0] = (int) Math.sqrt(temp[0] - (int) Math.pow(temp[1],2));
            } else {
                temp[0] = ((int) Math.sqrt(Math.abs(temp[0]) - (int) Math.pow(temp[1],2))) * -1;
            }

            solution[i] = temp;
        }
        
        return solution;
    }
}