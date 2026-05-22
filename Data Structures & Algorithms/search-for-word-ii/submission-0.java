class Solution {
    static final int[][] DIRS = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    class TrieNode {
        Map<Character, TrieNode> next = new HashMap<>();
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        var rows = board.length;
        var cols = board[0].length;
        var visited = new boolean[rows][cols];
        var result = new HashSet<String>();

        var trie = buildTrie(words);
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, rows, cols, trie, visited, result);
            }
        }
        return new ArrayList<>(result);
    }

    TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (var word : words) {
            var current = root;
            for (int i = 0; i < word.length(); i++) {
                current = current.next
                    .computeIfAbsent(word.charAt(i), r -> new TrieNode());
            }
            current.word = word;
        }
        return root;
    }

    void dfs(char[][] board, int r, int c, int rows, int cols, TrieNode trie, boolean[][] visited, Set<String> result) {
        if (!validPosition(r, c, rows, cols)) {
            return;
        }
        if (visited[r][c]) {
            return;
        }
        if (!trie.next.containsKey(board[r][c])) {
            return;
        }

        trie = trie.next.get(board[r][c]);
        if (trie.word != null) {
            result.add(trie.word);
        }

        visited[r][c] = true;
        for (var dir : DIRS) {
            dfs(board, r + dir[0], c + dir[1], rows, cols,
            trie, visited, result);
        }

        visited[r][c] = false;
    }

    boolean validPosition(int r, int c, int rows, int cols) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }
}
