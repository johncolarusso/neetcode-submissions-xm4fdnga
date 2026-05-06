class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue(
            // Comparator.comparingInt(p -> ((Pair) p).count()).reversed()
            (a, b) -> ((Pair)b).count() - ((Pair)a).count()
        );

        for (int n : nums) {
            counts.put(n, counts.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : counts.entrySet()) {
            pq.add(new Pair(e.getKey(), e.getValue()));
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().item();
        }

        return result;
    }
    record Pair(int item, int count){};
    // class Pair {
    //     int item;
    //     int count;

    //     public Pair(int item, int count) {
    //         this.item = item;
    //         this.
    //     }
    // }
}
