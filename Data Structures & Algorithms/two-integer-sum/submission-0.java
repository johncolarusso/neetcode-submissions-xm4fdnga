class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complements = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (complements.containsKey(target - nums[i])) {
                return new int[]{complements.get(target - nums[i]), i};
            }
            complements.put(nums[i], i);
        }

        return new int[]{};
    }
}
