class Solution {
    public int maxAscendingSum(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }

        int i = 1;
        int cur = nums[0];
        int result = nums[0];

        while (i < nums.length) {
            if (nums[i] > nums[i-1]) {
                cur += nums[i];
            } else {
                cur = nums[i];
            }
            result = Math.max(result, cur);
            i++;
        }
        return result;
    }
}