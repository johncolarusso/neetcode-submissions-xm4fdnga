class Solution {
    record Edge(int node, int time) {}
    // Dijkstra's
    public int networkDelayTime(int[][] times, int n, int k) {
        var graph = buildGraph(times, n);
        var result = dijkstra(graph, n, k);

        var max = 0;
        for (var res : result) {
            max = Math.max(res, max);
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

    int[] dijkstra(Map<Integer, List<Edge>> graph, int n, int k) {
        var dist = new int[n];
        var visited = new boolean[n];
        var heap = new PriorityQueue<Edge>((e1, e2) -> e1.time - e2.time);

        heap.add(new Edge(k, 0));
        Arrays.fill(dist, Integer.MAX_VALUE);

        while (!heap.isEmpty()) {
            var current = heap.poll();
            if (visited[current.node()-1]) {
                continue;
            }
            visited[current.node()-1] = true;
            if (current.time() > dist[current.node()-1]) {
                continue;
            }
            dist[current.node()-1] = Math.min(current.time(), dist[current.node()-1]);
            for (var neighbor : graph.getOrDefault(current.node(), new ArrayList<>())) {
                heap.offer(new Edge(neighbor.node(), current.time() + neighbor.time()));
            }
        }

        return dist;
    }
}
