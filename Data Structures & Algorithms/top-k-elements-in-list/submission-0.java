class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //nums=[1,2,2,3,3,3]
        //k=2
        // 1 -> 1
        // 2 -> 2
        // 3 -> 3
        int n = nums.length;
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        // rev = 1 -> [1], 2 -> [2], 3 -> [3]
        Map<Integer, List<Integer>> rev = new HashMap<>();
        for (Map.Entry<Integer, Integer> e : counts.entrySet()) {
            rev.computeIfAbsent(e.getValue(), key -> new ArrayList<>())
                .add(e.getKey());
        }

        // [3, 2]
        List<Integer> result = new ArrayList<>();
        for (int i = n; i > 0; i--) {
            if (rev.containsKey(i)) {
                List<Integer> temp = rev.get(i);
                result.addAll(temp);
                if (result.size() >= k) {
                    break;
                }
            }
        }

        // [3, 2]
        int[] resultArr = new int[k];
        for (int i = 0; i < k; i++) {
            resultArr[i] = result.get(i);
        }
        return resultArr;
    }
}
