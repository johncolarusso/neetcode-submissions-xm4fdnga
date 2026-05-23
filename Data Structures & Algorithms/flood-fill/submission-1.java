class Solution {
    record Coordinate(int r, int c){};
    static final List<Coordinate> DIRS = List.of(
        new Coordinate(1,0), new Coordinate(-1,0), new Coordinate(0,-1), new Coordinate(0,1)
    );
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        var rows = image.length;
        var cols = image[0].length;

        var prevColor = image[sr][sc];
        if (prevColor == color) {
            return image;
        }
        bfs(image, sr, sc, color, rows, cols, prevColor);

        return image;
    }

    void bfs(int[][] image, int sr, int sc, int newColor, int rows, int cols, int prevColor) {
        var queue = new ArrayDeque<Coordinate>();
        queue.offer(new Coordinate(sr, sc));

        while (!queue.isEmpty()) {
            var current = queue.poll();
            if (image[current.r()][current.c()] == prevColor) {
                image[current.r()][current.c()] = newColor;
                for (var dir : DIRS) {
                    var nextRow = current.r() + dir.r();
                    var nextCol = current.c() + dir.c();
                    if (isValid(image, nextRow, nextCol, rows, cols)) {
                        queue.offer(new Coordinate(nextRow, nextCol));
                    }
                }
            }
        }
    }

    boolean isValid(int[][] image, int sr, int sc, int rows, int cols) {
        return sr >= 0 && sr < rows && sc >= 0 && sc < cols;
    }
}