class Solution {
    public int[][] merge(int[][] intervals) {
        var sortedIntervals = intervals.clone();
        Arrays.sort(sortedIntervals, (i1, i2) -> i1[0] - i2[0]);

        var result = new ArrayList<int[]>();
        var current = sortedIntervals[0];
        result.add(current);
        for (int i = 1; i < sortedIntervals.length; i++) {
            if (current[1] >= sortedIntervals[i][0]) {
                current[1] = Math.max(current[1], sortedIntervals[i][1]);
            } else {
                current = sortedIntervals[i];
                result.add(current);
            }
        }

        return result.toArray(new int[][]{});
    }
}
