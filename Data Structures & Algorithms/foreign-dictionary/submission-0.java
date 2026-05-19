class Solution {
    // (1) DFS post-order
    // (2) Topological Sort

    private Map<Character, Set<Character>> adj;
    private Map<Character, VisitedEnum> visited;
    private List<String> result;

    enum VisitedEnum {
        VISITED, VISITING
    }

    public String foreignDictionary(String[] words) {
        try {
            buildAdjacencyList(words);
        } catch (LexError e) {
            return "";
        }
        result = new ArrayList<>();
        try {
            postOrderDfs();
        } catch (CycleException e) {
            return "";
        }
        Collections.reverse(result);
        return String.join("", result);
    }

    void buildAdjacencyList(String[] words) {
        adj = new HashMap<Character, Set<Character>>();
        for (String word : words)                    // ✅ Bug 1 fix
            for (char c : word.toCharArray())        // ✅ Bug 2 fix
                adj.putIfAbsent(c, new HashSet<>());

        for (int i = 0; i < words.length - 1; i++) {
            String from = words[i];
            String to = words[i+1];
            int minLength = Math.min(from.length(), to.length());
            if (from.length() > to.length() && from.substring(0, minLength).equals(to.substring(0, minLength))) {
                throw new LexError("Invalid words due to invalid ordering");
            }
            for (int j = 0; j < minLength; j++) {
                if (from.charAt(j) != to.charAt(j)) {
                    adj.computeIfAbsent(from.charAt(j), v -> new HashSet<Character>())
                        .add(to.charAt(j));
                    break;
                }
            }
        }
    }

    class LexError extends RuntimeException {
        public LexError(String error) {
            super(error);
        }
    }

    void postOrderDfs() {
        visited = new HashMap<Character, VisitedEnum>();
        for (Character c : adj.keySet()) {
            dfs(c);
        }
    }

    void dfs(Character c) {
        if (visited.containsKey(c)) {
            if (visited.get(c).equals(VisitedEnum.VISITING)) {
                throw new CycleException();
            }
            return;
        }

        visited.put(c, VisitedEnum.VISITING);

        for (char neighbor : adj.getOrDefault(c, new HashSet<>())) {
            dfs(neighbor);
        }

        visited.put(c, VisitedEnum.VISITED);
        result.add(c.toString());
    }

    class CycleException extends RuntimeException {}
}
