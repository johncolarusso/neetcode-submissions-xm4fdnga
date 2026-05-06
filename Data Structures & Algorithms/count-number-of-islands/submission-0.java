class Solution {
    static final List<Pair> directions = List.of(
        new Pair(1,0), new Pair(-1, 0), new Pair(0, 1), new Pair(0, -1)
    );
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Integer total = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                Pair p = new Pair(i, j);
                if (grid[i][j] == '1') {
                    bfs(i, j, grid);
                    total++;
                }
            }
        }
        return total;
    }

    record Pair(int x, int y){};

    private static void bfs(int i,
                            int j,
                            char[][] grid) {
        Deque<Pair> queue = new ArrayDeque<>();
        grid[i][j] = '0';
        queue.add(new Pair(i, j));
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            for (Pair direction : directions) {
                int newX = current.x() + direction.x();
                int newY = current.y() + direction.y();

                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == '1') {
                    queue.add(new Pair(newX, newY));
                    grid[newX][newY] = '0';
                }
            }           
        }
    }
}
