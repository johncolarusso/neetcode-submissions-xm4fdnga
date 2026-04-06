class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;

        int maxLeft = height[l];
        int maxRight = height[r];

        int result = 0;
        
        while (l < r) {
            if (maxLeft < maxRight) {
                l++;
                int water = Math.min(maxLeft, maxRight) - height[l];
                if (water > 0) {
                    result += water;
                }
                maxLeft = Math.max(maxLeft, height[l]);
            } else {
                r--;
                int water = Math.min(maxLeft, maxRight) - height[r];
                if (water > 0) {
                    result += water;
                }
                maxRight = Math.max(maxRight, height[r]);
            }
        }
        return result;
    }
}
