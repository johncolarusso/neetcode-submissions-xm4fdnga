class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> resultSet = new HashSet<>();

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            freq.put(nums[i], freq.get(nums[i]) - 1);

            for (int j = i+1; j < nums.length; j++) {
                freq.put(nums[j], freq.get(nums[j]) - 1);

                int target = (nums[i] + nums[j]) * -1;

                if (freq.getOrDefault(target, 0) > 0 && target >= nums[j]) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], target);
                    resultSet.add(temp);
                }
                freq.put(nums[j], freq.get(nums[j]) + 1);
            }
            freq.put(nums[i], freq.get(nums[i]) + 1);
        }

        result = new ArrayList<>(resultSet);
        return result;
    }
}