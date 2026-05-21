class Solution {
    static final int[][] DIRS = new int[][]{{0,1}, {1,0}, {-1, 0}, {0, -1}};
    record Cell(int r, int c){};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        var result = new ArrayList<List<Integer>>();
        int rows = heights.length;
        int cols = heights[0].length;
        var pacificQueue = new ArrayDeque<Cell>();
        var atlanticQueue = new ArrayDeque<Cell>();
        
        for (int r = 0; r < rows; r++) {
            pacificQueue.add(new Cell(r, 0));
            atlanticQueue.add(new Cell(r, cols - 1));
        }
        for (int c = 0; c < cols; c++) {
            pacificQueue.add(new Cell(0, c));
            atlanticQueue.add(new Cell(rows - 1, c));
        }
        
        var pacificResult = bfs(pacificQueue, heights, rows, cols);
        var atlanticResult = bfs(atlanticQueue, heights, rows, cols);

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacificResult[r][c] == true && atlanticResult[r][c] == true) {
                    result.add(List.of(r, c));
                }
            }
        }
        return result;
    }

    boolean[][] bfs(Deque<Cell> queue, int[][] heights, int rows, int cols) {
        var result = new boolean[rows][cols];

        for (var cell : queue) {
            result[cell.r()][cell.c()] = true;
        }

        while (!queue.isEmpty()) {
            var current = queue.poll();
            for (var dir : DIRS) {
                var newr = current.r() + dir[0];
                var newc = current.c() + dir[1];
                if (isValid(heights, newr, newc, rows, cols, result, current)) {
                    result[newr][newc] = true;
                    queue.offer(new Cell(newr, newc));
                }
            }
        }
        return result;
    }

    boolean isValid(int[][] heights, int r, int c, int rows, int cols, boolean[][] result, Cell current) {
        return r >= 0 && r < rows && c >= 0 && c < cols
        && heights[current.r()][current.c()] <= heights[r][c]
        && result[r][c] == false;
    }
}
