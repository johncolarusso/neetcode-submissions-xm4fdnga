class Solution {
    record Edge(int node, int time) {}
    // brute force DFS
    public int networkDelayTime(int[][] times, int n, int k) {
        var graph = buildGraph(times, n);
        var dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dfs(graph, k, n, 0, dist);

        var max = 0;
        for (var d : dist) {
            max = Math.max(d, max);
        }
        return max == Integer.MAX_VALUE ? -1 : max;
    }

    Map<Integer, List<Edge>> buildGraph(int[][] times, int n) {
        var result = new HashMap<Integer, List<Edge>>();
        for (var time : times) {
            result.computeIfAbsent(time[0], r -> new ArrayList<Edge>())
                .add(new Edge(time[1], time[2]));
        }
        return result;
    }

    void dfs(Map<Integer, List<Edge>> graph, int current, int n,
                int elapsed, int[] dist) {
        if (dist[current - 1] <= elapsed) {
            return;
        }
        dist[current - 1] = Math.min(elapsed, dist[current - 1]);
        
        for (var neighbor : graph.getOrDefault(current, new ArrayList<>())) {
            dfs(graph, neighbor.node(), n, elapsed + neighbor.time(), dist);
        }
    }
}
