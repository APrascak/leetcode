// Flood Fill
// 11 May 2020

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        return helper(image, sr, sc, newColor, image[sr][sc]);
    }
    
    private int[][] helper(int[][] image, int sr, int sc, int newColor, int oldColor) {
        // base case: out of bounds
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length)
            return image;
        // Check if the pixel has already been changed
        if (image[sr][sc] == newColor) {
            return image;
        }
        // Make sure the value matches the starting pixel color
        if (image[sr][sc] != oldColor)
            return image;
        
        // Update current pixel
        image[sr][sc] = newColor;
        
        // DFS call
        image = helper(image, sr+1, sc, newColor, oldColor);
        image = helper(image, sr-1, sc, newColor, oldColor);
        image = helper(image, sr, sc+1, newColor, oldColor);
        image = helper(image, sr, sc-1, newColor, oldColor);
        return image;
    }
}