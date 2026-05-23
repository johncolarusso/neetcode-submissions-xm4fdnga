class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        var rows = image.length;
        var cols = image[0].length;

        var oldColor = image[sr][sc];
        if (oldColor == color) {
            return image;
        }
        dfs(image, sr, sc, color, rows, cols, oldColor);

        return image;
    }

    void dfs(int[][] image, int sr, int sc, int color, int rows, int cols, int oldColor) {
        if (!isValid(image, sr, sc, rows, cols)) {
            return;
        }
        if (image[sr][sc] == oldColor) {
            image[sr][sc] = color;
            dfs(image, sr+1, sc, color, rows, cols, oldColor);
            dfs(image, sr-1, sc, color, rows, cols, oldColor);
            dfs(image, sr, sc+1, color, rows, cols, oldColor);
            dfs(image, sr, sc-1, color, rows, cols, oldColor);
        }
    }

    boolean isValid(int[][] image, int sr, int sc, int rows, int cols) {
        return sr >= 0 && sr < rows && sc >= 0 && sc < cols;
    }
}