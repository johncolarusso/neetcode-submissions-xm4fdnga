class Solution {
    record Dir(int r, int c){};
    static final List<Dir> DIRS =
        List.of(new Dir(0,1), new Dir(0,-1), new Dir(1,0), new Dir(-1,0));
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        
        var visited = new boolean[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                var result = dfs(board, word, r, c, 0, visited);
                if (result) return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, String word, int r, int c, int i, boolean[][] visited) {
        if (!isValid(r, c, board)) {
            return false;
        }
        if (word.charAt(i) != board[r][c]) {
            return false;
        }
        if (visited[r][c]) {
            return false;
        }
        if (i == word.length()-1) {
            return true;
        }

        visited[r][c] = true;

        var result = false;
        for (var dir : DIRS) {
            result |= dfs(board, word, r + dir.r(), c + dir.c(), i+1, visited);
        }
        if (result) {
            return true;
        }

        visited[r][c] = false;
        return false;
    }

    boolean isValid(int r, int c, char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }
}
