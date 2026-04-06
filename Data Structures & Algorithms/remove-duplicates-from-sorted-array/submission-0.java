class Solution {
    // [0, 1, 2, 2, 2, 2]
    //           l.    r

    // [ 2, 10, 10, 30, 30, 30]
    //          l.  r
    public int removeDuplicates(int[] nums) {
        int l = 1;
        int r = 1;

        while (r < nums.length) {
            if (nums[r] > nums[r-1]) {
                nums[l] = nums[r];
                l++;
            }
            r++;
        }
        return l;
    }
}