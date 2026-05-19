class Solution {
    private int[] parent;
    private int[] rank;
    private int components;

    public int countComponents(int n, int[][] edges) {
        initUnionFind(n, edges);
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }
        return components;
    }

    private void initUnionFind(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        components = n;
    }

    private int find(int n) {
        if (parent[n] == n) {
            return n;
        }
        return find(parent[n]);
    }

    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return;
        }

        int rankA = rank[rootA];
        int rankB = rank[rootB];
        if (rankB < rankA) {
            parent[rootB] = rootA;
        } else if (rankA < rankB) {
            parent[rootA] = rootB;
        } else {
            parent[rootA] = rootB;
            rank[rootB]++;
        }
        components--;
    }
}
