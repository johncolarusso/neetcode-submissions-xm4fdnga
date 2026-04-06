class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            // fix one num, 2sum
            if (i > 0 && i < nums.length && nums[i] == nums[i-1]) {
                i++;
                continue;
            }
            int j = i+1;
            int k = nums.length - 1;

            while (j < k) {

                int total = nums[i] + nums[j] + nums[k];
                if (total == 0) {
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    // skip duplicates
                    while (j < k && nums[j] == nums[j-1]) {
                        j++;
                    }
                } else if (total < 0) {
                    j++;
                } else if (total > 0) {
                    k--;
                }
            }

            // end of processing i
            i++;
        }

        return result;
    }
}