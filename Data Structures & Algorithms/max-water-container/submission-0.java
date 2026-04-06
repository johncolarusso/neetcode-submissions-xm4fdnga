class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length - 1;
        int max = -1;

        while (i < j) {
            int area = Math.min(heights[i], heights[j]) * (j - i);
            max = Math.max (area, max);

            if (heights[i] < heights[j]) {
                i++;
            } else if (heights[j] < heights[i]) {
                j--;
            } else {
                i++;
                j--;
            }
        }

        return max;
    }
}
