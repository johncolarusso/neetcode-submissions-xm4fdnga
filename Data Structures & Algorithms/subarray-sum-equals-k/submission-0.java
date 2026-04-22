class Solution {
    public int subarraySum(int[] nums, int k) {
        // 2, -1, 1, 2
        // sum: 2
        // pc: 0 -> 1
        int result = 0;
        Map<Integer, Integer> pc = new HashMap<>();
        pc.put(0, 1);

        int sum = 0;
        for (int n : nums) {
            sum += n;
            if (pc.containsKey(sum - k)) {
                result += pc.get(sum - k);
            }
            pc.put(sum, pc.getOrDefault(sum, 0) + 1);
        }
        return result;

    }
}