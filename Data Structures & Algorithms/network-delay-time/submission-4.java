class Solution {
    record Edge(int node, int time) {}
    // Dijkstra's
    public int networkDelayTime(int[][] times, int n, int k) {
        var graph = buildGraph(times, n);
        return dijkstra(graph, n, k);
    }

    Map<Integer, List<Edge>> buildGraph(int[][] times, int n) {
        var result = new HashMap<Integer, List<Edge>>();
        for (var time : times) {
            result.computeIfAbsent(time[0], r -> new ArrayList<Edge>())
                .add(new Edge(time[1], time[2]));
        }
        return result;
    }

    int dijkstra(Map<Integer, List<Edge>> graph, int n, int k) {
        var visited = new boolean[n+1];
        var heap = new PriorityQueue<Edge>((e1, e2) -> e1.time - e2.time);
        var nVisited = 0;
        var maxValue = 0;
        heap.add(new Edge(k, 0));

        while (!heap.isEmpty()) {
            var current = heap.poll();
            if (visited[current.node()]) {
                continue;
            }

            visited[current.node()] = true;
            nVisited++;
            maxValue = current.time();

            if (nVisited == n) {
                return maxValue;
            }
            for (var neighbor : graph.getOrDefault(current.node(), new ArrayList<>())) {
                heap.offer(new Edge(neighbor.node(), current.time() + neighbor.time()));
            }
        }

        return -1;
    }
}
