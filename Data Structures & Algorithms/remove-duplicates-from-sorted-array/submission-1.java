class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 0;
        int r = 0;

        while (r < nums.length) {
            nums[l] = nums[r];
            while (r < nums.length && nums[l] == nums[r]) {
                r++;
            }
            l++;
        }
        return l;
    }
}