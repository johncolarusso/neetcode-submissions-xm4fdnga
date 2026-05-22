class Solution {
    public int[] productExceptSelf(int[] nums) {
        var prefix = prefixProduct(nums);
        var suffix = suffixProduct(nums);

        var result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix[i] * suffix[i];
        }
        return result;
    }

    // prefix product except self
    int[] prefixProduct(int[] nums) {
        var result = new int[nums.length];
        result[0] = 1;
        for (var i = 1; i < nums.length; i++) {
            result[i] = result[i-1] * nums[i-1];
        }
        return result;
    }

    int[] suffixProduct(int[] nums) {
        var result = new int[nums.length];
        result[nums.length-1] = 1;
        for (var i = nums.length-2; i >= 0; i--) {
            result[i] = result[i+1] * nums[i+1];
        }
        return result;
    }
}  
