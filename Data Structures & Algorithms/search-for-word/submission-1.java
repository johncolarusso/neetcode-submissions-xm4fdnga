class Solution {
    // mutating the board to save space
    static final char MARKER = '#';

    record Dir(int r, int c){};
    static final List<Dir> DIRS =
        List.of(new Dir(0,1), new Dir(0,-1), new Dir(1,0), new Dir(-1,0));
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                var result = dfs(board, word, r, c, 0);
                if (result) return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, String word, int r, int c, int i) {
        if (!isValid(r, c, board)) {
            return false;
        }
        if (word.charAt(i) != board[r][c]) {
            return false;
        }
        if (board[r][c] == MARKER) {
            return false;
        }
        if (i == word.length()-1) {
            return true;
        }

        var temp = board[r][c];
        board[r][c] = MARKER;

        var result = false;
        for (var dir : DIRS) {
            result |= dfs(board, word, r + dir.r(), c + dir.c(), i+1);
        }
        if (result) {
            return true;
        }

        board[r][c] = temp;
        return false;
    }

    boolean isValid(int r, int c, char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }
}
