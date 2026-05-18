class Solution {
    private static final char WILDCARD = '_';
    public int ladderLength(String beginWord,
        String endWord, List<String> wordList) {
        // create adjacency list
        var adjacency = generateAdjacencyList(wordList);

        // run bfs to get the length of the shortest path
        return bfs(beginWord, endWord, adjacency);
    }

    Map<String, List<String>> generateAdjacencyList(List<String> wordList) {
        var result = new HashMap<String, List<String>>();

        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                sb.setCharAt(i, WILDCARD);
                result.computeIfAbsent(sb.toString(), r -> new ArrayList())
                        .add(word);
            }
        }
        return result;
    }
    
    int bfs(String beginWord, String endWord, Map<String, List<String>> adjacency) {
        Deque<Pair> deque = new ArrayDeque<>();
        deque.addLast(new Pair(beginWord, 1));
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!deque.isEmpty()) {
            Pair current = deque.removeFirst();
            for (int i = 0; i < current.word().length(); i++) {
                StringBuilder sb = new StringBuilder(current.word());
                sb.setCharAt(i, WILDCARD);
                String pattern = sb.toString();
                List<String> neighbors = adjacency.get(pattern);
                if (neighbors != null) {
                    for (String neighbor : neighbors) {
                        if (neighbor.equals(endWord)) {
                            return current.length() + 1;
                        }

                        if (!visited.contains(neighbor)) {
                            visited.add(neighbor);
                            deque.addLast(new Pair(neighbor, current.length() + 1));
                        }
                    }
                }
            }
        }
        return 0;
    }

    private record Pair(String word, int length){};
}
