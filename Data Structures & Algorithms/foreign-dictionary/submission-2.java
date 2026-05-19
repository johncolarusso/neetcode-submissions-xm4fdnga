class Solution {
    // dag top sort
    private Map<Character, Set<Character>> adj;
    private Map<Character, Integer> indegree;
    private StringBuilder result;

    public String foreignDictionary(String[] words) {
        if (!createAdjacencyList(words)) {
            return "";
        }

        if (!topSort()) {
            return "";
        }

        return result.toString();
    }

    boolean createAdjacencyList(String[] words) {
        adj = new HashMap<Character, Set<Character>>();
        indegree = new HashMap<>();
        for (var word : words) {
            for (var ch : word.toCharArray()) {
                adj.putIfAbsent(ch, new HashSet<Character>());
                indegree.putIfAbsent(ch, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            var word1 = words[i];
            var word2 = words[i+1];
            var minLength = Math.min(word1.length(), word2.length());
            if (word1.length() > word2.length() && word1.substring(0, minLength).equals(word2.substring(0, minLength))) {
                return false;
            }
            for (int j = 0; j < minLength; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    if (adj.get(word1.charAt(j)).add(word2.charAt(j))) {
                        indegree.merge(word2.charAt(j), 1, Integer::sum);
                    }
                    break;
                }
            }
        }

        return true;
    }

    boolean topSort() {
        result = new StringBuilder();
        var queue = new ArrayDeque<Character>();
        for (var c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }
        while (!queue.isEmpty()) {
            var current = queue.poll();
            result.append(current.toString());
            for (var neighbor : adj.getOrDefault(current, new HashSet<>())) {
                indegree.merge(neighbor, -1, Integer::sum);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (result.length() != indegree.size()) {
            return false;
        }
        return true;
    }
}
